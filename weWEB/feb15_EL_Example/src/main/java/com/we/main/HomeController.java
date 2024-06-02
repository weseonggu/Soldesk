package com.we.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) {
			Judge.getJ().getRandomNum();
			System.out.println("랜덤값: "+Judge.getJ().getNum());
			request.getRequestDispatcher("output.jsp").forward(request, response);			
		}else {
			if(Judge.getJ().upDown(request)) {
				Judge.getJ().getRandomNum();
				System.out.println("랜덤값: "+Judge.getJ().getNum());
				request.getRequestDispatcher("output.jsp").forward(request, response);
			}else {				
				request.getRequestDispatcher("output.jsp").forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("output.jsp").forward(request, response);	
	}

}
