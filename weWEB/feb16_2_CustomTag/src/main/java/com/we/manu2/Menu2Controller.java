package com.we.manu2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Menu2Controller")
public class Menu2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Menu2Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("homea", "jsp/calc/input.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			Calculator.getC().calc(request);
			request.getRequestDispatcher("jsp/calc/output.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
