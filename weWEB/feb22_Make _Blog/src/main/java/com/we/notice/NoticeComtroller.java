package com.we.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we.member.MemberDAO;

@WebServlet("/NoticeComtroller")
public class NoticeComtroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeComtroller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MemberDAO.loginCheck(request)) {
			request.getSession().setAttribute("search", null);// search세션 지우기
			// 페이지 피리메타 구하기 첫접속null = page=>1 그후 페이지 파라메타에서
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
