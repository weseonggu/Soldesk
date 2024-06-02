package com.we.add;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("show", "jsp/add/input.jsp");
		}else {
			Calculator.getC().numAdd(request);
			request.setAttribute("show", "jsp/add/output.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calculator.getC().numAdd(request);
		request.setAttribute("show", "jsp/add/output.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
