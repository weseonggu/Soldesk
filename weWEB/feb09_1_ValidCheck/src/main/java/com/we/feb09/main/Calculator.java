package com.we.feb09.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("EUC-KR");
		

		int x = Integer.parseInt(request.getParameter("x")); 
		int y = Integer.parseInt(request.getParameter("y"));
		String _do = request.getParameter("do");
		int result=0;
		if(_do.equals("+")) {
			result=x+y;
		}else if(_do.equals("-")) {
			result=x-y;
		}else if(_do.equals("*")) {
			result=x*y;
		}else if(_do.equals("/")) {
			result=x/y;
		}
		
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title></head><body>");

		pw.printf("<h1>%d %s %d = %d</h1>",x,_do,y,result );
		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("EUC-KR");
//		request.setCharacterEncoding("EUC-KR");
		
		
		

		String path = request.getSession().getServletContext().getRealPath("text");
//		System.out.println(path);
		MultipartRequest mr = new MultipartRequest(
				request,path,10*1024*1024,
				"euc-kr",new DefaultFileRenamePolicy());
		
		int x = Integer.parseInt(mr.getParameter("x")); 
		int y = Integer.parseInt(mr.getParameter("y"));
		String _do = mr.getParameter("do");
		
		String txtf= mr.getFilesystemName("txtf");
		String origin_filename=txtf;
		txtf=URLEncoder.encode(txtf, "euc-kr");//URLDecoder.decode(txtf, "euc-kr");
		txtf=txtf.replace("+", " ");
		
		int result=0;
		if(_do.equals("+")) {
			result=x+y;
		}else if(_do.equals("-")) {
			result=x-y;
		}else if(_do.equals("*")) {
			result=x*y;
		}else if(_do.equals("/")) {
			result=x/y;
		}
		
		BufferedWriter bw=null;
		String filename= String.format("%s/%s",path,origin_filename);
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
			bw =new BufferedWriter(osw);
			bw.write(String.format("%d", result));
			bw.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		try {
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title></head><body>");

		pw.printf("<h1>%d %s %d = %d</h1>",x,_do,y,result );
		pw.printf("<h1>%s</h1>",txtf);
		pw.printf("<a href= \"text/%s\">다운받기</a>",origin_filename);
		pw.print("</body></html>");
	}

}
