package com.we.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we.member.MemberDAO;

@WebServlet("/NoticeDeleteController")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MemberDAO.loginCheck(request)) {
			if(NoticeDAO.getNdao().deleteNotice(request)) {
				NoticeDAO.getNdao().goDetail(request);
				NoticeDAO.getNdao().get(1, request);
				request.setAttribute("show", "jsp/notice/notice.jsp");				
			}else {
				request.setAttribute("show", "jsp/notice/notice.jsp");				
			}
		}else {
			request.setAttribute("show", "jsp/home/home.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
