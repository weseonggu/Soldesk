package com.we.snack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SnackController")
public class SnackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SnackController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SnackDAO.getSdao().reg(request);
		request.setAttribute("cp", "snack/regForm.jsp");
		SnackDAO.getSdao().get("1",request);
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
