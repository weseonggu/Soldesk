package com.we.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberInfoController() {
        super();
    }
    // 회원 정보 가기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MemberDAO.loginCheck(request)) {
			request.setAttribute("show", "jsp/member/info.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);			
		}else {
			request.setAttribute("show", "jsp/home/home.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
	// 회원 정보 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MemberDAO.loginCheck(request)) {
			MemberDAO.infoChange(request);
			request.setAttribute("show", "jsp/member/info.jsp");
			// 수정시도
		}else {
			// 수정x
			request.setAttribute("show", "jsp/home/home.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
