package com.we.miniproject.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.we.miniproject.DateManager;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO mDAO;
	// 아이디 중복 검사
	@RequestMapping(value = "/member.id.check", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Members macroGet(Member m) {
		// 이 프로젝트 외부의 JavaScript에서도 쓸 수 있게
		return mDAO.getMemberInfo(m); 
	}
	
	// 가입하러 가기
	@RequestMapping(value = "/signUp.menber", method = RequestMethod.GET)
	public String signUpMenber(Member m, HttpServletRequest req) {
		DateManager.getCurYear(req);
		mDAO.isLogined(req);
		req.setAttribute("contents", "member/join.jsp");
		return "index";
	}
	// 가입 하기
	@RequestMapping(value = "/member.join.do", method = RequestMethod.POST)
	public String memberJoinDo(Member m,HttpServletRequest req,RedirectAttributes re){
		mDAO.join(m,req,re);
		mDAO.isLogined(req);
		req.setAttribute("contents", "home.jsp");
		return "redirect:/";
	}
	//로그인 하기
//	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
//	public String memberloginDo(Member m,HttpServletRequest req){
//		mDAO.login(m, req);
//		mDAO.isLogined(req);
//		req.setAttribute("contents", "home.jsp");
//		return "index";
//	}
	// 로그인후 자동으로 메인 페이지 주소로 이동 하기
//	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
//	public RedirectView memberloginDo(Member m,HttpServletRequest req){
//		mDAO.login(m, req);
//		mDAO.isLogined(req);
//		req.setAttribute("contents", "home.jsp");
//		return new RedirectView("/miniproject/");
//	}
	// 로그인후 자동으로 메인 페이지 주소로 이동 하기
	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String memberloginDo(Member m,HttpServletRequest req,RedirectAttributes re){
		mDAO.login(m, req, re);
		mDAO.isLogined(req);
		req.setAttribute("contents", "home.jsp");
		return "redirect:/";
	}
	// 로그인후 자동으로 메인 페이지 주소로 이동 하기
//	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
//	public RedirectView memberloginDo(Member m,HttpServletRequest req){
//		mDAO.login(m, req);
//		mDAO.isLogined(req);
//		req.setAttribute("contents", "home.jsp");
//		RedirectView rv =new RedirectView("/miniproject/");
//		rv.addStaticAttribute("result", "가입 성공");
//		return rv;
//	}
	//로그아웃 하기
	@RequestMapping(value = "/click.logout", method = RequestMethod.GET)
		public String memberlogoutDo(HttpServletRequest req){
			mDAO.clicklogout(req);
			mDAO.isLogined(req);
			req.setAttribute("contents", "home.jsp");
			return "redirect:/";
		}
	// 회원 정보 페이지
	@RequestMapping(value = "/click.info", method = RequestMethod.GET)
	public String memberlnfoGo(HttpServletRequest req){
		if(mDAO.isLogined(req)) {
			mDAO.splitAddress(req);
			req.setAttribute("contents", "member/memberInfo.jsp");
		}else {
			req.setAttribute("contents", "home.jsp");
		}
		return "index";
	}
	// 회원 탈퇴
	@RequestMapping(value = "/click.info.bye", method = RequestMethod.GET)
	public String memberByeGo(HttpServletRequest req,RedirectAttributes re){
		if(mDAO.isLogined(req)) {
			mDAO.bye(req,re);
			mDAO.isLogined(req);
			req.setAttribute("contents", "home.jsp");
		}else {
			req.setAttribute("contents", "home.jsp");
		}
		return "redirect:/";
	}
	// 회원 정보 변경
	@RequestMapping(value = "/member.info.change", method = RequestMethod.POST)
	public String memberInfoChange(HttpServletRequest req,RedirectAttributes re){
		if(mDAO.isLogined(req)) {
			mDAO.changeInfo(req, re);
			mDAO.isLogined(req);
			req.setAttribute("contents", "home.jsp");
		}else {
			req.setAttribute("contents", "home.jsp");
		}
		return "redirect:/";
	}
	
	
}
