package com.we.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCoffee")
public class GetCoffee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetCoffee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String coffeeData = CofeeDAO.getData(request);
		System.out.println("커피"+coffeeData);
		PrintWriter pw =response.getWriter();
		pw.print(coffeeData);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
