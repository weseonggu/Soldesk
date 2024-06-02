package com.we.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.getMdao().login(request, response);
		if(MemberDAO.getMdao().isLogined(request)) {
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}
