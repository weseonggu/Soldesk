package com.we.feb07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class GugudanServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("누가 GET방식 요청함?");
		

		response.setCharacterEncoding("EUC-KR");
		
		//?변수명=값&변수명=값... 요청 파라미터
		// 요청 파라미터 값 읽기
		int x = Integer.parseInt(request.getParameter("xxx"));
		int y = Integer.parseInt(request.getParameter("yyy"));
		
		//서버와 클라이언트 사이의 랜선에 붙어 있는 응답용 빨대
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title></head><body>"); // 응답 변수없이 그냥 넣어 됨

		pw.print("<table border =\"1\">");
		pw.printf("<tr><td>%d + %d=%d</td></tr>",x,y,x+y);
		pw.printf("<tr><td>%d - %d=%d</td></tr>",x,y,x-y);
		pw.printf("<tr><td>%d * %d=%d</td></tr>",x,y,x*y);
		pw.printf("<tr><td>%d / %d=%d</td></tr>",x,y,x/y);
		pw.print("</table>");
		
		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
