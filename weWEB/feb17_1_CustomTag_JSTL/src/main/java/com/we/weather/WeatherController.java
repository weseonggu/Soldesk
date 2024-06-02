package com.we.weather;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1135063000
@WebServlet("/WeatherController")
public class WeatherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public WeatherController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("show", "jsp/weather/showWeather.jsp");
		Weather.getW().getWeather(request);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
