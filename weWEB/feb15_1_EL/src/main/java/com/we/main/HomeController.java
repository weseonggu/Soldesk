package com.we.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HomeController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getAttributeNames().hasMoreElements()) {
			request.getRequestDispatcher("input.html").forward(request, response);			
		}else {
			
			request.getRequestDispatcher("output.jsp").forward(request, response);	
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AgeCalculator.getAgecalculator().getAge(request);
		request.getRequestDispatcher("output.jsp").forward(request, response);	
	}

}
