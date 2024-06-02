package com.we.snack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SnackCurvController")
public class SnackSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SnackSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cp", "snack/regForm.jsp");
		String search = request.getParameter("search");
		request.getSession().setAttribute("search", search);
		SnackDAO.getSdao().get("1",request);
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
