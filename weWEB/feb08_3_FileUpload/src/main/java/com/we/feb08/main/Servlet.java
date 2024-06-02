package com.we.feb08.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setCharacterEncoding("EUC-KR");
//		
//
//		String title = request.getParameter("title");
//		PrintWriter pw = response.getWriter();
//		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title></head><body>");
//
//		pw.printf("<h1>제목: %s</h1>", title);
//		pw.print("</body></html>");
	}

	//4. 다른 포장방식으로 데이터가 넘어오니, 데이터 읽는게 바뀔것
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("EUC-KR");
		request.setCharacterEncoding("EUC-KR");
		
		//4-1 파일이 업로드될 폴더 절대경로 필요 -> 구해줌
		String path = request.getSession().getServletContext().getRealPath("img");
		System.out.println(path);
		
		MultipartRequest mr = new MultipartRequest(
				request,// 기존 요청객체
				path,// 파일이 업로드 될 폴더 절대경로
				10*1024*1024,// 파일 용량 제한(넘기면 exception) 바이트 단위
				"euc-kr",//요청 파라메터 인코딩 방식
				new DefaultFileRenamePolicy()//파일명 중복처리
				);
		//5. 파일업로드 처리
		
		//6. 업로드한 파일명
		//String fname = mr.getParameter("photo); //이거 아님 업로드시 파일명 바뀜
		String fname = mr.getFilesystemName("photo");
		// 톰캣이 한글로된 파일명을 인식 못함
		fname=URLEncoder.encode(fname, "euc-kr");// 파일명 인식하는걸로 변경
		// 띄어쓰기는 +로 변경
		fname=fname.replace("+", " ");
		//4-3 데이터 볼려면 MultipartRequest객체를 사용해야함
		String title = mr.getParameter("title");
		
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title></head><body>");

		pw.printf("<h1>제목: %s</h1>", title);
		pw.printf("<img src=\"img/%s\">", fname);
		pw.print("</body></html>");
	}

}
