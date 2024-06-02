package com.we.miniproject.dataroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.we.miniproject.TokenGenerater;
import com.we.miniproject.member.MemberDAO;

@Controller
public class DataroomController {
	
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private DataDAO dDAO;
	
	// 자료실로 가기
	@RequestMapping(value = "/dataroom.go", method = RequestMethod.GET)
	public String doDataroom(HttpServletRequest req) {
		if(mDAO.isLogined(req)) {
			TokenGenerater.generater(req);
			dDAO.showData(req);
			req.setAttribute("contents", "dataRoom/dataRoom.jsp");
		}else {
			req.setAttribute("result", "로그인 후 이욜 바랍니다.");
		}
		return "index";
	}
	
	//자료 업로드
	@RequestMapping(value = "/dataroom.upload", method = RequestMethod.POST)
	public String uploadFile(DataInfo di, HttpServletRequest req,RedirectAttributes re) {
		if(mDAO.isLogined(req)) {
			dDAO.uploadFile(req, di,re);
		}else {
			re.addFlashAttribute("result","로그아웃됨");
		}
		return "redirect:/dataroom.go";
	}
	
	// 다운로드
	@RequestMapping(value = "/data.download", method = RequestMethod.GET)
	public String dataDown(DataInfo di,HttpServletRequest req, HttpServletResponse res) {
		if(mDAO.isLogined(req)) {
			TokenGenerater.generater(req);
			dDAO.download(req, res, di);
			req.setAttribute("contents", "dataRoom/dataRoom.jsp");
		}else {
			req.setAttribute("result", "로그인 후 이욜 바랍니다.");
		}
		return "index";
	}
}
