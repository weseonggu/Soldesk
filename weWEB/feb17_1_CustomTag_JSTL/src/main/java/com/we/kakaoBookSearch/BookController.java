package com.we.kakaoBookSearch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()){
			
			request.setAttribute("show", "jsp/book/input.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("show", "jsp/book/input.jsp");
			Book.getB().searchBook(request, response);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
