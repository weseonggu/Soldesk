package com.we.mar066.point;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PointController {
	
	@Autowired
	private PointCalculater pc;// 설명 : PointController는  PointCalculater에 의존한고 있다.
	// 따라서 PointControler가 생성 될 때  servlet-context에 있는 해당 클래스 부분의 데이터를 찾어서  
	//PointCalculater의 객체를 생성 한다. 여기서 객체는 pc가 된다. 
	
	// get 방식은 한글처리 톰캣이 알아서 해줌
	// post방식은 setCharacterEncoding("utf-8") 사용해야 함 -> 문제 이미 잃고 나서 인코딩은 무의미
	@RequestMapping(value = "/point.calc", method = RequestMethod.POST)
	public String pointCalculate(PointInfo p, HttpServletRequest req) {

		// req.setCharacterEncoding("utf-8");// 이미 데이터를 읽음
		System.out.println(p.getName());
		System.out.println(p.getPrice());
		pc.calculate(p, req);

		return "output";
	}
}
