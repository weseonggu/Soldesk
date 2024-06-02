package com.we.member;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.we.DBManager.copy.DBManager;
import com.we.notice.NoticeDAO;

public class MemberDAO {

	// 사진의 크기 예외 IOException, DB접속예외 NamingException, sql예외 SQLException
	public static void getJoinFormData(HttpServletRequest request) throws IOException, SQLException, NamingException {
		// post한글 처리
		request.setCharacterEncoding("EUC-KR");
		// 사진데이터 인코딩하기 위한 처리
		// 저장 위치 경로 자동으로 가져오기
		String path = request.getSession().getServletContext().getRealPath("img");
		// 인코딩 객체 선언 cos.jar 외부라이브러리 사용
		MultipartRequest mr = new MultipartRequest(request, path, 10485760, "euc-kr", new DefaultFileRenamePolicy());

		// form에서 데이터 가져오기
		String id = mr.getParameter("id");
		String pw = mr.getParameter("pw");
		String uName = mr.getParameter("uName");
		String year = mr.getParameter("year");
		// 날짜 처리
		int month = Integer.parseInt(mr.getParameter("month"));
		int day = Integer.parseInt(mr.getParameter("day"));
		String birth = String.format("%s%02d%02d", year, month, day);
		// 사진 이름 처리
		String photo = mr.getFilesystemName("photo");
		photo = URLEncoder.encode(photo, "euc-kr");
		photo = photo.replace("+", " ");
		// 사진용량 오류로 서버의 저장된 이미지도 삭제 처리해야함
		// 난 잘못 작성해서 못하는 상황

//		File f = new File(path+"/"+mr.getFilesystemName("photo"));
//		f.delete();
		// 위코드로 처리가능try-catch문

		// DB에 데이터 넣기
		insertFormDataToDB(id, pw, uName, birth, photo);

	}

	// DB접속예외 NamingException, sql예외 SQLException
	private static void insertFormDataToDB(String id, String pw, String uName, String birth, String photo)
			throws SQLException, NamingException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// DBPOOL에 접속 DBManager 사용
		con = DBManager.connectPool("wewe");
		// sql작성
		String sql = "INSERT INTO project_member values(?,?,?,TO_DATE(?,'YYYYMMDD'),?)";
		pstmt = con.prepareStatement(sql);
		// sql완성
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, uName);
		pstmt.setString(4, birth);
		pstmt.setString(5, photo);

		// sql실행
		pstmt.executeUpdate();

		DBManager.dbClose(con, pstmt, null);
	}

	// 로그인 기능
	public static void login(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connectPool("wewe");

			request.setCharacterEncoding("euc-kr");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			// where id, pw가 같은것만 데이터를 가져오는건 보안상 위험함 sqlinjection 으로 공격 가능하기 때문에 위험함
			String sql = "SELECT * from project_member where pm_id= ?";
			// id만 검색해서 데이터를 가져와서 pw를 검사하는 방식을 사용한다.
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbPW = rs.getString("pm_pw");
				if (pw.equals(dbPW)) {
					// 로그인 성공 정보가 사이트 어디서든지 사용가능하도록 -> session
					Member m = new Member();
					m.setId(id);
					m.setPw(pw);
					m.setName(rs.getString("pm_name"));
					m.setBirthday(rs.getDate("pm_birthday"));
					m.setPhoto(rs.getString("pm_photo"));

					request.getSession().setAttribute("loginMember", m);
//					request.getSession().setMaxInactiveInterval(3000);

				} else {
					request.setAttribute("alert", "실패 : 비번 클림");
				}
			} else {
				request.setAttribute("alert", "로그인 실패");
			}

			while (rs.next()) {
				System.out.println(rs.getString("pm_id"));
				System.out.println(rs.getString("pm_pw"));
				System.out.println(rs.getString("pm_name"));
				System.out.println(rs.getString("pm_birthday"));
				System.out.println(rs.getString("pm_photo"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		DBManager.dbClose(con, pstmt, rs);
	}

	// 세션이 말료 되었는지 확인 (로그인 가능한지 확인)
	public static boolean loginCheck(HttpServletRequest request) {
		if (request.getSession().getAttribute("loginMember") != null) {
			request.setAttribute("login", "jsp/member/logout.jsp");
			return true;
		} else {
			request.setAttribute("login", "jsp/member/login.jsp");
			return false;
		}
	}

	// 세션에서 있는거 지우기 (로그아웃)
	public static void logout(HttpServletRequest request) {
		// session 끊기(세센에 멥버 정보 말고 도 다른거들도 있을거기 때문에 부적함)
		// request.getSession().setMaxInactiveInterval(-1);
		request.getSession().setAttribute("loginMember", null);
	}

	// 유저 탈퇴 (DB에서 지우고 서버의 이미지 파일 지우기)
	public static void deleteUser(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int dcount = deleteUserNoticeCount(request);
		try {
			con = DBManager.connectPool("wewe");
			String sql = "DELETE from project_member where pm_id = ?";
			pstmt = con.prepareStatement(sql);
			Member m = (Member) request.getSession().getAttribute("loginMember");
			pstmt.setString(1, m.getId());
			if (pstmt.executeUpdate() == 1) {
				long allNoticeCount = NoticeDAO.getNdao().getAllNoticeCount();
				NoticeDAO.getNdao().setAllNoticeCount(allNoticeCount-dcount);
				System.out.println("탈퇴 후"+(NoticeDAO.getNdao().getAllNoticeCount()));
				
				request.setAttribute("alert", m.getName() + "님이 탈퇴하셨습니다");
				String path = request.getSession().getServletContext().getRealPath("img");
				File f = new File(path + "/" + URLDecoder.decode(m.getPhoto(), "euc-kr"));
				f.delete();
			} else {
				request.setAttribute("alert", "이미탈퇴하셨습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		DBManager.dbClose(con, pstmt, null);
	}
	// 회원 정보 수정
	public static void infoChange(HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("img");
		System.out.println(path);
		MultipartRequest mr = null;
		Connection con =null;
		PreparedStatement pstmt = null;
		Member m = (Member) request.getSession().getAttribute("loginMember");
		// 할일 프사, pw변경
		// 예외 프사설정 용량 초과 예외 처리 ok
		// db프사 or pw만 변경 ok
		// db프사 pw둘다 변경 ok
		// 프사 변경 세션의 member객체의 photo pw 변경
		// 변경 후 전 프사 삭제
		// 수정 실패시 서버의 이미지 삭제
		
		String oldPhoto = m.getPhoto();
		String newPhoto =null;
		String pw =null;
		String id =m.getId();
		try {
			mr = new MultipartRequest(request, path, 10485760, "euc-kr", new DefaultFileRenamePolicy());
			newPhoto = mr.getFilesystemName("changePhoto");
		} catch (Exception e) {
			// TODO: handle exception
			// 프사 용량 최과 예외 발생
//			File f= new File(path + "/" + mr.getFilesystemName("changePhoto"));
//			f.delete();
			request.setAttribute("alert", "수정 실패");
		}
		
		try {
			if(newPhoto == null) {// 비번만 변경
				pw = mr.getParameter("changPW");
				newPhoto = m.getPhoto();
				m.setPw(pw);
			}else { // 둘다 변경
				pw = mr.getParameter("changPW");
				System.out.println("비번: " +pw);// 여기서 약간의 무제 발생 칸이 비어 있으면 db에러 발생
				if(pw == "") {
					pw =m.getPw();
					System.out.println("비번: " +pw);
				}
				System.out.println(newPhoto);
				newPhoto = URLEncoder.encode(newPhoto, "euc-kr");
				newPhoto = newPhoto.replace("+", " ");
				m.setPw(pw);
				m.setPhoto(newPhoto);
				// 예전 프사 삭제
				File f;
				try {
					System.out.println("dPwjsR:   "+oldPhoto);
					f = new File(path + "/" + URLDecoder.decode(oldPhoto, "euc-kr"));
					f.delete();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("에전파일 예외");
				}
			}
			
			// DB UPdate
			con = DBManager.connectPool("wewe");
			String sql ="update project_member set pm_pw = ?, pm_photo = ? where pm_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			System.out.println(newPhoto);
			pstmt.setString(2, newPhoto);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
			request.getSession().setAttribute("loginMember", m);
			request.setAttribute("alert", "수정 성공");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("db실패");
			e.printStackTrace();
		}
	}
	// 탈퇴 계정이 쓴 글 수 
	public static int deleteUserNoticeCount(HttpServletRequest request) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		Member m = (Member)request.getSession().getAttribute("loginMember");
		try {
			con = DBManager.connectPool("wewe");
			String sql = "select count(*) from bpbascp_notice where bn_writer = ?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt("count(*)");
			DBManager.dbClose(con, pstmt, rs);
			return count;
			
		} catch (Exception e) {
			// TODO: handle exception
			DBManager.dbClose(con, pstmt, rs);
			return 0;
		}
		
		
	}
	
	public static void getData(HttpServletRequest request) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		ArrayList<data> arr = new ArrayList<>();
		
		try {
			con = DBManager.connectPool("wewe");
			String sql = "select c_name, c_price from feb28_coffee";
			pstmt= con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(rs.next());
			while(rs.next()) {
				System.out.println(rs.getString("c_name"));
				System.out.println(rs.getInt("c_price"));
				arr.add(new data(rs.getString("c_name"), rs.getInt("c_price")));
			}
			// 웹사이트랑 상관없는 외부인에게 데이터를 주자 json, xml
			request.setAttribute("arr", arr);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DBManager.dbClose(con, pstmt, rs);
	}
}
