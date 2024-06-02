package com.we.home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we.member.MemberDAO;
import com.we.notice.NoticeDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // main() :  tomcat에 -> was에서만 실행됨
	//C .jsp를 객체는 tomcat이 만듬
	// 이벤트루프 돌려서 ->요청 들어오면 처리후 복귀헤서 다시 루프
	//event-driven programming
    public HomeController() {
    	NoticeDAO.getNdao().getNoticveCount();
    }
    // 첫 접속
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.getData(request);
		MemberDAO.loginCheck(request);
		request.setAttribute("show", "jsp/home/home.jsp");

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
