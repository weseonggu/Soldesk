package com.we.JSTLFormating;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JSTLFormatingController")
public class JSTLFormatingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JSTLFormatingController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a =123456789;
		request.setAttribute("aaa", a);
		
		double b = 0.123456789;
		request.setAttribute("bbb", b);
		
		String c ="123.456789";
		request.setAttribute("ccc", c);
		
		String d ="2023-02-20";
		request.setAttribute("ddd", d);
		
		Date e  = new Date();
		request.setAttribute("eee", e);
		
		
		
		
		request.setAttribute("show", "jsp/jstl_formating/test.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
