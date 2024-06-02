package com.we.mar201.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDAO {
	@Autowired
	private SqlSession ss;
	
	public void getData(HttpServletRequest req) {
		try {
			List<Menu> menus = ss.getMapper(Mapper.class).getData();
			req.setAttribute("menus", menus);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Menus getDataAsXML() {

		return new Menus( ss.getMapper(Mapper.class).getData());			

	}
	
	public String reg(Menu m) {
		try {
			if(ss.getMapper(Mapper.class).reg(m)==1) {
				return "<result>성공</result>";
			}
			return null;
		} catch (Exception e) {
			return "<result>실패</result>";
		}
	}
	
	
	public Menus search(Menu m) {
		return new Menus(ss.getMapper(Mapper.class).search(m));
	}
}
