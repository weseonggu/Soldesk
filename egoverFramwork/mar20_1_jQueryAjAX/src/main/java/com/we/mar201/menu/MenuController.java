package com.we.mar201.menu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MenuController {
	@Autowired
	private MenuDAO mDAO;
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String getMenu(HttpServletRequest req) {
//		mDAO.getData(req);
//		return "index";
//	}
	@RequestMapping(value = "/menu.get", method = RequestMethod.GET, produces ="application/xml; charset=utf-8")
	public @ResponseBody Menus getMenuAsXML() {
		return mDAO.getDataAsXML();
	}
	
	@RequestMapping(value = "/menu.reg", method = RequestMethod.GET, produces ="application/xml; charset=utf-8")
	public @ResponseBody String regMenu(Menu m) {
		return mDAO.reg(m);
	}
	
	@RequestMapping(value = "/menu.search", method = RequestMethod.GET, produces ="application/xml; charset=utf-8")
	public @ResponseBody Menus searchMenu(Menu m) {
		return mDAO.search(m);
		}
}
