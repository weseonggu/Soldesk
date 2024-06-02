package com.we.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we.home.DateManager;

@WebServlet("/JoinController")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 페이지 접속
		//년도 데이터
		DateManager.getCurYear(request);
		
//		MemberDAO.loginCheck(request);
		request.setAttribute("show", "jsp/member/join.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 가입 버튼 클릭후
		try {
			MemberDAO.getJoinFormData(request);
			MemberDAO.loginCheck(request);
			request.setAttribute("show", "jsp/home/home.jsp");
			request.setAttribute("alert", "가입성공");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
			DateManager.getCurYear(request);
//			MemberDAO.loginCheck(request);
			request.setAttribute("show", "jsp/member/join.jsp");
			request.setAttribute("exception", "사진용량초과");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch (NamingException e) {
			e.printStackTrace();
			DateManager.getCurYear(request);
//			MemberDAO.loginCheck(request);
			request.setAttribute("show", "jsp/member/join.jsp");
			request.setAttribute("exception", "DB접속실패");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch (SQLException e) {
			e.printStackTrace();
			DateManager.getCurYear(request);
//			MemberDAO.loginCheck(request);
			request.setAttribute("show", "jsp/member/join.jsp");
			request.setAttribute("exception", "데이터 추가 못함");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
