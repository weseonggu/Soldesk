package com.we.lotto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LottoController")
public class LottoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LottoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) {
			Lotto.getL().getNum(request);
			request.setAttribute("show", "jsp/lotto/output.jsp");
		}else {
			Lotto.getL().getNum(request);
			request.setAttribute("show", "jsp/lotto/output.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
