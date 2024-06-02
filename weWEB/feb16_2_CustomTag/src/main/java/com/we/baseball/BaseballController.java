package com.we.baseball;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BaseballController")
public class BaseballController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BaseballController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) {
			SBO.getSbo().getNum();
			request.setAttribute("homea", "jsp/baseball/output.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			if(SBO.getSbo().judge(request)) {
				SBO.getSbo().getNum();
				request.setAttribute("homea", "jsp/baseball/output.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				request.setAttribute("homea", "jsp/baseball/output.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
