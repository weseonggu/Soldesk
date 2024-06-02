package com.we.miniproject.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.we.miniproject.TokenGenerater;
import com.we.miniproject.member.MemberDAO;

@Controller
public class SnsController {
	
	@Autowired
	private SnsDAO sDAO;
	
	@Autowired
	private MemberDAO mDAO;
	
	// 글보러가기
	@RequestMapping(value = "/sns.go", method = RequestMethod.GET)
	public String snsGo(SnsPost sp, HttpServletRequest req) {
		if(mDAO.isLogined(req)) {
			req.getSession().setAttribute("search", null);
			sDAO.getSnsPost(sp, req);
			TokenGenerater.generater(req);
			req.setAttribute("contents", "sns/sns.jsp");
		}else {
			
			req.setAttribute("contents", "home.jsp");
		}
		return "index";
	}
	
	//글쓰기
	@RequestMapping(value = "/sns.post.write", method = RequestMethod.GET)
	public String snsPostWrite(SnsPost sp, HttpServletRequest req,RedirectAttributes re) {
		if(mDAO.isLogined(req)) {
			sDAO.writePost(sp, req, re);
		}else {
			re.addFlashAttribute("result", "글 쓰기 실패(로그아웃 됨)");
		}
		return "redirect:/sns.go";
	}
	
	//글삭제
	@RequestMapping(value = "/sns.delete", method = RequestMethod.GET)
	public String snsDelete(SnsPost sp, HttpServletRequest req,RedirectAttributes re) {
		if(mDAO.isLogined(req)) {
			sDAO.postDelete(sp, req, re);
		}else {
			re.addFlashAttribute("result", "글 삭제 실패(로그아웃 됨)");
		}
		return "redirect:/sns.go";
	}
	
	//글 수정
	@RequestMapping(value = "/sns.rewrite", method = RequestMethod.GET)
	public String snsRewrite(SnsPost sp, HttpServletRequest req,RedirectAttributes re) {
		if(mDAO.isLogined(req)) {
			
		}else {
			re.addFlashAttribute("result", "글 삭제 실패(로그아웃 됨)");
		}
		return "redirect:/sns.go";
	}
	
	
	
	// 댓글 쓰기
	@RequestMapping(value = "/sns.comment", method = RequestMethod.GET)
	public String snsCommentWrite(SnsComment sc, HttpServletRequest req,RedirectAttributes re) {
		if(mDAO.isLogined(req)) {
			sDAO.writeSnsComment(req, sc, re);
		}else {
			re.addFlashAttribute("result", "글 삭제 실패(로그아웃 됨)");
		}
		return "redirect:/sns.go";
	}
	
	
	
	

	
	
	
}
