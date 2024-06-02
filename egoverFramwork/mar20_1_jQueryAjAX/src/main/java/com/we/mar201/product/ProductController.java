package com.we.mar201.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO pDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getMenu(HttpServletRequest req) {
		return "index2";
	}
	
	@RequestMapping(value = "/product.json", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Products getProductAsJSON(@RequestParam(value ="page") int page, HttpServletResponse res) {
		
		// cross-domain방1 설정
		res.setHeader("Access-Control-Allow-Origin", "*");
		// 이 프로젝트 외부의 JavaScript에서도 쓸 수 있게
		return pDAO.getProduct(page);
	}
}
