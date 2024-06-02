package com.we.data;

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

		
//		response.setCharacterEncoding("UTF-8");
//		String coffeeData = CofeeDAO.getData(request);
//		PrintWriter pw =response.getWriter();
//		pw.print(coffeeData);
		
		response.addHeader("Content-Type", "application/json; charset=utf-8");// 확장 프로 그램 필요함
		response.setCharacterEncoding("UTF-8");
		String coffeeData = GetCoffeeJson.getData(request);
		PrintWriter pw =response.getWriter();
		pw.print(coffeeData);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
