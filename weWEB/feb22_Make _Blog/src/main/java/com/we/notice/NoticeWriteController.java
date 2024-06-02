package com.we.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we.member.MemberDAO;

@WebServlet("/NoticeWriteController")
public class NoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeWriteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MemberDAO.loginCheck(request)) {
			// 파라메터로 쓰러가기 인지 쓴거 db에 저장하는 건지 구별해서 처리
			if(!request.getParameterNames().hasMoreElements()) {
				//글쓰러 가기
				TokenGenerator.gernerate(request);
				request.setAttribute("show", "jsp/notice/write.jsp");
			}else {
				//DB작업 글 db에저장
				request.getSession().setAttribute("search", null);// search세션 지우기
				NoticeDAO.getNdao().write(request);
				NoticeDAO.getNdao().get(1,request);
				request.setAttribute("show", "jsp/notice/notice.jsp");
				
			}
		}else {
			//request.setAttribute("show", "jsp/notice/write.jsp");
			request.setAttribute("show", "jsp/home/home.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
