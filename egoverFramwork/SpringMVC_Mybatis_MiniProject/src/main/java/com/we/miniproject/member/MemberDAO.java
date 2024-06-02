package com.we.miniproject.member;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.we.miniproject.sns.SnsDAO;
import com.we.miniproject.sns.SnsMapper;

@Service
public class MemberDAO {
	@Autowired
	private SqlSession ss;
	@Autowired
	private SnsDAO sDAO;
	
	// 중복 검사 ?bm_id=dnltjdrn 라적으면 아이디의 대한 json데이터를 가지고 온다.
	public Members getMemberInfo(Member m) {
		m =ss.getMapper(MemberMapper.class).getMemberByID(m);
		ArrayList<Member> members = new ArrayList<Member>();
		members.add(m);
		return new Members(members);
	}

	// 가입
	public void join(Member m, HttpServletRequest request,RedirectAttributes re) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("resources/img");
		System.out.println(path);
		try {
			mr = new MultipartRequest(request, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e1) {
			// 이미지 문제로 인한 실패
			re.addFlashAttribute("result", "가입실패(이미지)");
			e1.printStackTrace();
		}

		try {

			String birth = mr.getParameter("year") + String.format("%02d", Integer.parseInt(mr.getParameter("month")))
					+ String.format("%02d", Integer.parseInt(mr.getParameter("day")));
			String addr = mr.getParameter("addr1") + "$" + mr.getParameter("addr2") + "$" + mr.getParameter("addr3");
			String photo = mr.getFilesystemName("bm_photo");
			photo = URLEncoder.encode(photo, "utf-8");
			photo = photo.replace("+", " ");

			m.setBm_name(mr.getParameter("bm_name"));
			m.setBm_id(mr.getParameter("bm_id"));
			m.setBm_pw(mr.getParameter("bm_pw"));
			m.setBm_birthday(sdf.parse(birth));
			m.setBm_address(addr);
			m.setBm_photo(photo);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				re.addFlashAttribute("result", "가입성공");
			}
		} catch (Exception e) {
			// db나 기타 문제 인한 실패
			re.addFlashAttribute("result", "가입실패");
			File f = new File(path + "/" + mr.getFilesystemName("bm_photo"));
			f.delete();
			e.printStackTrace();
		}
	}

	// 로그인
	public void login(Member m, HttpServletRequest req, RedirectAttributes re) {
		try {
			Member loginMember = ss.getMapper(MemberMapper.class).getMemberByID(m);
			
			if (loginMember != null) {
				if (loginMember.getBm_pw().equals(m.getBm_pw())) {
					// 비번 일치
					req.getSession().setAttribute("loginMember", loginMember);
				} else {
					// 비번 불일치
					re.addFlashAttribute("result", "비번 불일치");
				}

			} else {
				re.addFlashAttribute("result", "로그인 실패");
			}
		} catch (Exception e) {
			re.addFlashAttribute("result", "로그인 실패");
			e.printStackTrace();
		}
	}

	// 로그인 상태확인(세션에 loginMember있는지 검사)
	public boolean isLogined(HttpServletRequest req) {
		if (req.getSession().getAttribute("loginMember") != null) {
			req.setAttribute("login", "member/logout.jsp");
			return true;
		} else {
			req.setAttribute("login", "member/login.jsp");
			return false;
		}
	}

	// 로그아웃하기
	public void clicklogout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}

	// 주소 나누기
	public void splitAddress(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String bm_addr = m.getBm_address();
		System.out.println(bm_addr);
		String[] bm_addr2 = bm_addr.split("\\$");
		req.setAttribute("addr1", bm_addr2[0]);
		req.setAttribute("addr2", bm_addr2[1]);
		req.setAttribute("addr3", bm_addr2[2]);
	}

	// 탈퇴
	public void bye(HttpServletRequest req,RedirectAttributes re) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/img");
			Member m = (Member) req.getSession().getAttribute("loginMember");
			int post=ss.getMapper(SnsMapper.class).withdrawMember(m);// 탈퇴후 글수 처리
			if (ss.getMapper(MemberMapper.class).bye(m) == 1) {
				File f = new File(path + "/" + m.getBm_photo());
				f.delete();// 프사 삭제
				clicklogout(req);// 로그아웃 (세션 제거)
				re.addFlashAttribute("result", "탈퇴성공");
				// 탈퇴후 글수 처리
				System.out.println("글지우기수: "+post);
				sDAO.setAllPoatCount(sDAO.getAllPoatCount()-post);
			} else {
				re.addFlashAttribute("result", "탈퇴 실페");
			}
		} catch (Exception e) {
			re.addFlashAttribute("result", "탈퇴 실페");
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	// 회원 정보 수정
	public void changeInfo(HttpServletRequest request,RedirectAttributes re) {
		// 프사 안바꾸는 db문제로 실패 or성공
		// 프사 바꾸는 사람 파일 용량 문제로 실패 ->db작업x
		// db문제로 실패 이미업로듣 ㅚㄴ 파일 삭제
		// 성공 -> 옛날 프사파일 삭제
		String path = request.getSession().getServletContext().getRealPath("resources/img");
		System.out.println(path);
		MultipartRequest mr = null;
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String oldPhoto = m.getBm_photo();
		String newPhoto = null;
		String pw = null;
		try {
			mr = new MultipartRequest(request, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
			newPhoto = mr.getFilesystemName("bm_photo");
		} catch (Exception e) {
			// TODO: handle exception
			// 프사 용량 최과 예외 발생
//			File f= new File(path + "/" + mr.getFilesystemName("changePhoto"));
//			f.delete();
			re.addFlashAttribute("result", "수정 실패");
			System.out.println("db실패");
			e.printStackTrace();
		}
		try {
			if (newPhoto == null) {// 비번만 변경
				pw = mr.getParameter("bm_pw");
				newPhoto = m.getBm_photo();
				m.setBm_pw(pw);
			} else { // 둘다 변경
				pw = mr.getParameter("bm_pw");
				System.out.println("비번: " + pw);// 여기서 약간의 무제 발생 칸이 비어 있으면 db에러 발생
				if (pw==null) {
					pw = m.getBm_pw();
//					System.out.println("비번: " +pw);
				}
				System.out.println(newPhoto);
				newPhoto = URLEncoder.encode(newPhoto, "utf-8");
				newPhoto = newPhoto.replace("+", " ");
				m.setBm_pw(pw);
				m.setBm_photo(newPhoto);
				// 예전 프사 삭제
				File f;
				try {
					System.out.println("dPwjsR:   " + oldPhoto);
					f = new File(path + "/" + URLDecoder.decode(oldPhoto, "euc-kr"));
					f.delete();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
//					System.out.println("에전파일 예외");
				}
			}
			String addr = mr.getParameter("addr1")+"$"+
			mr.getParameter("addr2")+"$"+
			mr.getParameter("addr3");
			m.setBm_address(addr);
			
			
			
//			System.out.println(m.getBm_id());
//			System.out.println(m.getBm_name());
//			System.out.println(m.getBm_pw());
//			System.out.println(m.getBm_photo());
//			System.out.println(m.getBm_birthday());
//			System.out.println(m.getBm_address());
			// DB UPdate
			if (ss.getMapper(MemberMapper.class).infoChage(m) == 1) {
				re.addFlashAttribute("result", "변경성공");
				request.getSession().setAttribute("loginMember", m);
//				System.out.println("변경성공");
			}
		} catch (Exception e) {
			// TODO: handle exception
//			System.out.println("db실패");
			re.addFlashAttribute("result", "db실패");
			e.printStackTrace();
		}

	}

}
