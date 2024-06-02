package com.we.second;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondController")
public class SecondController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SecondM.pirntData(request);
		SecondM.makeData(request,response);
		request.getRequestDispatcher("second.jsp").forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
	}
	
	

}
