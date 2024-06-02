package com.we.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ByeController")
public class ByeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ByeController() {
        super();
    }
    // 회원 탈퇴
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MemberDAO.loginCheck(request)) {
			// 탈퇴
			MemberDAO.deleteUser(request);
			MemberDAO.logout(request);
			MemberDAO.loginCheck(request);
		}
		request.setAttribute("show", "jsp/home/home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
