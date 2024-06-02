package com.we.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we.member.MemberDAO;

@WebServlet("/NoticeSearchController")
public class NoticeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeSearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MemberDAO.loginCheck(request)) {
			NoticeDAO.getNdao().search(request);
			int page;
			if(request.getParameter("p")==null) {
				page=1;
			}else {
				page = Integer.parseInt(request.getParameter("p"));
			}
			NoticeDAO.getNdao().get(page,request);
			request.setAttribute("show", "jsp/notice/notice.jsp");
		}else {
			request.setAttribute("show", "jsp/home/home.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
