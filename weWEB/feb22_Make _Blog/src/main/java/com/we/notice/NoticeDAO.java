package com.we.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.we.DBManager.copy.DBManager;
import com.we.member.Member;

public class NoticeDAO {
	private static final NoticeDAO NDAO = new NoticeDAO();
	private long allNoticeCount;
	private int noticePerPage;
	
	private NoticeDAO() {
		noticePerPage =10;
	}

	public static NoticeDAO getNdao() {
		return NDAO;
	}
	
	
	public long getAllNoticeCount() {
		return allNoticeCount;
	}

	public void setAllNoticeCount(long allNoticeCount) {
		this.allNoticeCount = allNoticeCount;
	}

	public void write(HttpServletRequest request) {		
		Connection con =null;
		PreparedStatement pstmt =null;
		try {
			String title = request.getParameter("title");
			String txt = request.getParameter("txt");
			// 웹페이지에서 엔터 쓸거면 <br>로 변견해야함
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String id =m.getId();
			String token = request.getParameter("token");
			String lastToken = (String)request.getSession().getAttribute("sucessToken");
			if(lastToken != null && token.equals(lastToken)) {
				request.setAttribute("alert", "글쓰기 실패(새로고침)");
				return;
			}
			
			con = DBManager.connectPool("wewe");
			String sql ="insert into bpbascp_notice values "
					+ "(bpbascp_notice_seq.nextval,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, txt);
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("alert", "글쓰기 성공");
				request.getSession().setAttribute("sucessToken", token);
				allNoticeCount++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("alert", "글쓰기 실패");
		}
		DBManager.dbClose(con, pstmt, null);
		
	}

	public void get(int page,HttpServletRequest request) {
		//select 로 Arraylist처리
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			con = DBManager.connectPool("wewe");
			// 검색인 전체 조회인지 구분하기
			long noticePage = allNoticeCount;
			String search = (String)request.getSession().getAttribute("search");
			if(search == null) {
				//전체 조회
				search ="";
			}else {
				//검색 조회
				noticePage=getSearchCount(search);
			}
			// 총페이지 수 한페이지당 10개의 글
			int pageCount =(int) Math.ceil((double)noticePage / noticePerPage);
			request.setAttribute("pageCount", pageCount);
			//db에서 데이터 가져오기
			//getNoticveCount();// 나중에 지우기
			int end=page*noticePerPage;
			int start=end-(noticePerPage-1);
			String sql = "select * from("
					+ "select ROWNUM as rn, bn_no, bn_writer, bn_title, bn_date from ("
					+ "select bn_no,bn_writer,bn_title,bn_txt,bn_date from bpbascp_notice "
					+ "where bn_title like '%'||?||'%' or bn_txt like '%'||?||'%' "
					+ "order by bn_date desc)"
					+ ")where rn >=? and rn<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			rs = pstmt.executeQuery();
			ArrayList<Notice> notices = new ArrayList<>();
			while(rs.next()) {
				notices.add(new Notice(rs.getInt("bn_no")
						, rs.getString("bn_writer")
						, rs.getString("bn_title")
						, rs.getDate("bn_date")));
			}
			request.setAttribute("notices", notices);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		DBManager.dbClose(con, pstmt, rs);
	}

	public void getNoticveCount() {
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			con = DBManager.connectPool("wewe");
			String sql = "select count(*) as count from bpbascp_notice";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			System.out.println("처음접속후 공지사항 수"+rs.getInt("count"));
			this.allNoticeCount = rs.getInt("count");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		DBManager.dbClose(con, pstmt, rs);
	}

	public void search(HttpServletRequest request) {
		String s =request.getParameter("search");
		request.getSession().setAttribute("search", s);
	}

	private int getSearchCount(String s) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		int sCount=0;
		try {
			con = DBManager.connectPool("wewe");
			String sql = "select count(*) from bpbascp_notice where bn_title like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s);
			rs = pstmt.executeQuery();
			rs.next();
			sCount = rs.getInt("count(*)");
		} catch (Exception e) {
			// TODO: handle exception
		}
		DBManager.dbClose(con, pstmt, rs);
		return sCount;
	}

	public boolean goDetail(HttpServletRequest request) {
		String no = request.getParameter("n");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice n = null;
		Member m =null;
		try {
			con = DBManager.connectPool("wewe");
			String sql = "select bn_no, bn_writer, bn_title, bn_date, bn_txt "
					+ "from bpbascp_notice "
					+ "where bn_no = ?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				n = new Notice();
				n =new Notice(rs.getString("bn_writer"),
						rs.getString("bn_title"),
						rs.getString("bn_txt"),
						rs.getDate("bn_date"));
				n.setNo(rs.getInt("bn_no"));
				m=getWriterInfo(n);
				request.setAttribute("ndetail", n);
				request.setAttribute("ndata", m);
				DBManager.dbClose(con, pstmt, rs);
				return true;
			}else {
				
				DBManager.dbClose(con, pstmt, rs);
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			DBManager.dbClose(con, pstmt, rs);
			return false;
		}
	}
	
	private Member getWriterInfo(Notice n) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m =null;
		try {
			con = DBManager.connectPool("wewe");
			String sql = "select pm_photo, pm_name "
					+ "from project_member "
					+ "where pm_id = ?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, n.getWriter());
			rs = pstmt.executeQuery();
			rs.next();
			m = new Member();
			m.setName(rs.getString("pm_name"));
			m.setPhoto(rs.getString("pm_photo"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DBManager.dbClose(con, pstmt, rs);
		return m;
	}
	
	public boolean deleteNotice(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int no =Integer.parseInt(request.getParameter("nno"));// Attribute의 필드는 못가져오는가?
		System.out.println(no);
		try {
			con= DBManager.connectPool("wewe");
			String sql="DELETE FROM bpbascp_notice WHERE bn_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			if(pstmt.executeUpdate()==1) {
				request.setAttribute("alert", "삭제성공");
				allNoticeCount--;
				DBManager.dbClose(con, pstmt, null);
				return true;
			}else {
				request.setAttribute("alert", "삭제실패");
				DBManager.dbClose(con, pstmt, null);
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			DBManager.dbClose(con, pstmt, null);
			return false;
		}
		
	}
	
	public void modifyNotice(HttpServletRequest request) {
		
	}
	public void writeComment(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			int noticeNO = Integer.parseInt(request.getParameter("n"));
			String txt = request.getParameter("txt");
			String token = request.getParameter("token");
			Member m = (Member)request.getSession().getAttribute("loginMember");
			String lastToken = (String)request.getSession().getAttribute("sucessToken");
			if(lastToken != null && token.equals(lastToken)) {
				request.setAttribute("alert", "글쓰기 실패(새로고침)");
				return;
			}
			con = DBManager.connectPool("wewe");
			String sql="INSERT into bpbascp_notice_reply VALUES(notice_comment_seq.nextval, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNO);
			pstmt.setString(2, m.getId());
			pstmt.setString(3, txt);
			
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("alert", "댓글 성공");
				request.getSession().setAttribute("sucessToken", token);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void getComment(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int n = Integer.parseInt(request.getParameter("n"));
		try {
			con = DBManager.connectPool("wewe");
			String spl = "SELECT * from bpbascp_notice_reply where bnr_bn_no = ?";
			pstmt  = con.prepareStatement(spl);
			pstmt.setInt(1, n);
			rs = pstmt.executeQuery();
			ArrayList<Comment> comments = new ArrayList<>();
			Comment c = null;
			while(rs.next()) {
				c = new Comment();
				c.setBnr_no(rs.getInt("bnr_no"));
				c.setBnr_bn_no(rs.getInt("bnr_bn_no"));
				c.setBnr_writer(rs.getString("bnr_writer"));
				c.setBnr_txt(rs.getString("bnr_txt"));
				c.setBnr_date(rs.getDate("bnr_date"));
				comments.add(c);
			}
			request.setAttribute("comments", comments);
		} catch (Exception e) {
			// TODO: handle exception
		}
		DBManager.dbClose(con, pstmt, rs);
		
	}
}
