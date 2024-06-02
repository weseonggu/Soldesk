package com.we.feb09.main;

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


@WebServlet("/ResizeImg")
public class ResizeImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResizeImg() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	// 예외를 굳이 서버까지 와서 예외발생시키는 건 아니다. 낭비!!
	// 잘못썼으면 서블릿 쪽으로 출발도 안하게 처리하는게 더 좋고 이렇게 해야함
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("EUC-KR");
		String path = request.getSession().getServletContext().getRealPath("img");
		MultipartRequest mr = new MultipartRequest(
				request,path,10*1024*1024,
				"euc-kr",new DefaultFileRenamePolicy());
		
		// 숫자가 들어와야하는 데 글자나 숫자가 아닌게 들어오면 안된다
		// 입력 유효성 검사(valid check)
		int width =0;
		int height =0;
		
		String imgf = URLEncoder.encode(mr.getFilesystemName("img"), "euc-kr").replace("+", " ");
		
		
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title>");
		pw.printf("<style>img{width: %dpx;height: %dpx;object-fit: cover;}</style>", width,height);
		
		pw.print("</head><body>");
		try {
			width = Integer.parseInt(mr.getParameter("width")); 
			height = Integer.parseInt(mr.getParameter("height"));			
			pw.printf("<img src=\"img/%s\">",imgf);
		} 
		catch (NumberFormatException e) {
			// TODO: handle exception
			pw.print("<h1>숫자만써라</h1>");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		pw.print("</body></html>");
		
		
		
		
		
		
		
		
		
	}

}
