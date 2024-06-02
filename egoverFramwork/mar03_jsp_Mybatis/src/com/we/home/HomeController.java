package com.we.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we.DBManager.DBManager_ver3;
import com.we.snack.SnackDAO;
// C는 WebContent에 잇다고 보면 됨
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
        DBManager_ver3.getDbm().setFacory("com/we/home/config.xml");
        SnackDAO.getSdao().getCount();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cp", "snack/regForm.jsp");
		String p = request.getParameter("p");
		if(p==null) {
			p="1";
		}
		SnackDAO.getSdao().get(p,request);
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
