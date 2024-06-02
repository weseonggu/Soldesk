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
@WebServlet("/GugudanServlet")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GugudanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("누가 GET방식 요청함?");
		

		response.setCharacterEncoding("EUC-KR");

		Random r = new Random();
		int x = r.nextInt(10);

		
		//서버와 클라이언트 사이의 랜선에 붙어 있는 응답용 빨대
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title></head><body>"); // 응답 변수없이 그냥 넣어 됨
//		for (int i =2 ; i<10;i++) {
//			html+="<tr>";
//			html+=String.format("<td>%d단</td>", i);
//			for( int j =1 ; j<10;j++) {
//				html+=String.format("<td>%d</td>", j*i);
//			}
//			html+="</tr>";
//		}
		for (int i =2 ; i<10;i++) {
			pw.print("<table style=\"float: left\"; border=\"1\">");
			pw.print(String.format("<tr><td>%d단</td>", i));
			for( int j =1 ; j<10;j++) {
				pw.print(String.format("<tr><td>%d*%d=%d</td></tr>",j,i ,j*i));
			}
			pw.print("</table>");
		}
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
