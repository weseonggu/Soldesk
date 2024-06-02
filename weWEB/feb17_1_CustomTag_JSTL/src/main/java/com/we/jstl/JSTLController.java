package com.we.jstl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JSTLController")
public class JSTLController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JSTLController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) {
			DataMaker.make(request);
			request.setAttribute("show", "jsp/jstl/input.jsp");
		}else {
			DataMaker.make(request);
			request.setAttribute("show", "jsp/jstl/input.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
