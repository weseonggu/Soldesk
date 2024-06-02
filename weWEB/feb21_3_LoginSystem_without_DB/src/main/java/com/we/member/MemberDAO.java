package com.we.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {
	private static final MemberDAO MDAO = new MemberDAO();

	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	public static MemberDAO getMdao() {
		return MDAO;
	}

	public boolean isLogined(HttpServletRequest request) {
		return (request.getSession().getAttribute("loginID") != null);
	}

	public void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("euc-kr");

			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			System.out.println(id);
			System.out.println(pw);
			if (id.equals("test") && pw.equals("1234")) {
				Cookie c = new Cookie("loginID", id);
				// 아이디 저장
				c.setMaxAge(1 * 60 * 60 * 24);
				response.addCookie(c);
				// 성공
				// 로그인정보가 사이트에서 어딜가든지 사용 가능해야함
				// 장시간 미사용 시 풀려야함
				// -> session사용
				request.getSession().setAttribute("loginID", id);
				request.getSession().setAttribute("loginPW", pw);
				request.getSession().setMaxInactiveInterval(10);
			} else {
				// 실패
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
