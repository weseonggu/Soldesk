package com.we.feb13.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("euc-kr");
		
		int x = Integer.parseInt(request.getParameter("xx"));
		int y = Integer.parseInt(request.getParameter("yy"));
		int bigger =(x>y) ? x:y;
		
		
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title></head><body>"); // 응답 변수없이 그냥 넣어 됨
		pw.printf("<h1>%d</h1>",bigger);
		pw.print("</body></html>");
	}
//jsp:  html/css/js기반에 필요한 부분에 java를 넣는거

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
