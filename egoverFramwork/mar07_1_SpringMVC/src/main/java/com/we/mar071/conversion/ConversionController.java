package com.we.mar071.conversion;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConversionController {
	@Autowired
	private ConversionDAO uc;
	
	@RequestMapping(value = "/conversion.do", method = RequestMethod.GET)
	public String convert(
			@RequestParam(value = "n") double n,
			HttpServletRequest req
			) 
	{
		uc.convert(n, req);
		
		return "output";
	}
}
