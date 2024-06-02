package com.we.feb07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanServlet
 */
@WebServlet("/NewGugudan")
public class NewGugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewGugudan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("누가 GET방식 요청함?");

		response.setCharacterEncoding("EUC-KR");

		int dan = Integer.parseInt(request.getParameter("dan"));
		int border = Integer.parseInt(request.getParameter("border"));

		// 서버와 클라이언트 사이의 랜선에 붙어 있는 응답용 빨대
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title></head><body>");
																													
		pw.printf("<table style=\"float: left\"; border=\"%d\">",border);
		pw.printf("<tr><td>%d단</td>", dan);
		for (int j = 2; j < 10; j++) {
			pw.printf("<tr><td>%d*%d=%d</td></tr>", j, dan, j * dan);
		}
		pw.print("</table>");


		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
