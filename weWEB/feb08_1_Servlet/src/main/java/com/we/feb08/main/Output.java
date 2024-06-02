package com.we.feb08.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Output
 */
@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Output() {
		super();
		// main은 tomcat에
		// Output 객체는 tomcat이 만들고, 이벤트 루프 시작
		// 최초로 서비스 시작할때
		System.out.println("이 사이트 첫 시작");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get방식: 요청퍼러메터가 주소에 
		// 		tomcat이 자동으로 파라미터의 값을 인코딩 디코딩함(iso-8859-1방식 사용)
		// 설정을 변경해야 함 server.xml파일에서 변경
		response.setCharacterEncoding("EUC-KR");

		int a = Integer.parseInt(request.getParameter("aa"));
		String s=request.getParameter("dd");
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title></head><body>");

		pw.printf("<h1>%s</h1>",a%2==1 ? "홀수": "짝수");
		pw.printf("<h1>%s</h1>", s);
		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post방식: 요청 파라메터가 주소에 없고, 내부적으로 전달
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		int a = Integer.parseInt(request.getParameter("aa"));
		String s=request.getParameter("dd");
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title></head><body>");

		pw.printf("<h1>%s</h1>",a%2==1 ? "홀수": "짝수");
		pw.printf("<h1>%s</h1>", s);
		pw.print("</body></html>");

	}
	

	

}
