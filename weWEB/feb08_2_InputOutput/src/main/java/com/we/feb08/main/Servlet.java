package com.we.feb08.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("EUC-KR");

		String name=request.getParameter("name");
		String id =request.getParameter("ID");
		String pw1 =request.getParameter("PW");
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title></head><body>");

		pw.printf("<h1>이름: %s</h1>", name);
		pw.printf("<h1>ID: %s</h1>", id);
		pw.printf("<h1>PW: %s</h1>", pw1);
		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("EUC-KR");
		request.setCharacterEncoding("EUC-KR");

		String name=request.getParameter("name");
		String id =request.getParameter("ID");
		String pw1 =request.getParameter("PW");
		String addr =request.getParameter("ADDR");
		String home =request.getParameter("home");
		String[] h =request.getParameterValues("hobby");
		String[] m =request.getParameterValues("move");
		String hi=request.getParameter("hi");
		hi=hi.replace("\r\n", "<br>");
		String hobby="";
		String move="";
		if(h==null) {
			hobby = "취미 없음";
		}else {
			for (String string : h) {
				hobby+=string+" ";  
			}
		}
		if(m==null) {
			move = "비대면";
		}else {
			for (String string : m) {
				move+=string+" ";  
			}
		}
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title></head><body>");

		pw.printf("<h1>이름: %s</h1>", name);
		pw.printf("<h1>ID: %s</h1>", id);
		pw.printf("<h1>PW: %s</h1>", pw1);
		pw.printf("<h1>주소: %s</h1>", addr);
		pw.printf("<h1>집: %s</h1>", home);
		pw.printf("<h1>취미: %s</h1>", hobby);
		pw.printf("<h1>이동수단: %s</h1>", move);
		pw.printf("<h1>인사말: %s</h1>", hi);		
		pw.print("</body></html>");
	}

}
