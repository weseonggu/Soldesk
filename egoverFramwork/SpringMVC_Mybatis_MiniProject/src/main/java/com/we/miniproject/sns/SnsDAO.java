package com.we.miniproject.sns;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.we.miniproject.BPBACPValue;
import com.we.miniproject.member.Member;
@Service
public class SnsDAO {
	@Autowired
	private SqlSession ss;
	@Autowired
	private BPBACPValue bo;
	
	
	private int allPoatCount;
	

	public int getAllPoatCount() {
		return allPoatCount;
	}
	public void setAllPoatCount(int allPoatCount) {
		this.allPoatCount = allPoatCount;
	}
	// 글쓰기
	public void writePost(SnsPost sp, HttpServletRequest req, RedirectAttributes re) {
		try {
			// 새로 고침
			String token =req.getParameter("token");
			String lastSuccessToken = (String)req.getSession().getAttribute("successToken");
			
			if(token.equals(lastSuccessToken)) {
				re.addFlashAttribute("result", "글쓰기 실패(새로고침)");
				return;
			}
			
			Member m = (Member)req.getSession().getAttribute("loginMember");
			
			sp.setBs_writer(m.getBm_id());
			sp.setBs_txt(sp.getBs_txt().replace("\r\n", "<br>"));//줄바꿈 
			
			
			if(ss.getMapper(SnsMapper.class).writePost(sp)==1) {
				allPoatCount++;
				re.addFlashAttribute("result", "글쓰기 성공");
				req.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			re.addFlashAttribute("result", "글쓰기 실패");
		}
	}
	// 굴 수정하기
	public void snsRewrite(HttpServletRequest req, SnsPost s, RedirectAttributes re) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	// 글 가져와서 보여주기
	public void getSnsPost(SnsPost sp,HttpServletRequest req) {
		try {
//			System.out.println("페이지당 수"+bo.getSnsPostPage());
			
			int page = (int)Math.ceil((double)allPoatCount/bo.getSnsPostPage());
			int seepage;
			try {
				seepage = Integer.parseInt( req.getParameter("page"));				
			} catch (Exception e) {
				seepage=1;
			}
			String search = req.getParameter("search");
			HashMap<String, String> searchMap = new HashMap<String, String>();
			if(search==null) {
				if(req.getSession().getAttribute("search")==null) {
					search="";
				}
			}else {
				searchMap.put("search", search);
				int searchPage = ss.getMapper(SnsMapper.class).searchPost(searchMap);
				page = (int)Math.ceil((double)searchPage/bo.getSnsPostPage());
				req.getSession().setAttribute("search", search);
			}
			
			int end = seepage*bo.getSnsPostPage();
			int start = end - (bo.getSnsPostPage()-1);
			
			HashMap<String, String> condition = new HashMap<String, String>();
			condition.put("start", start+"");
			condition.put("end", end+"");
			condition.put("search", search);
			
			List<SnsPost> posts = ss.getMapper(SnsMapper.class).getSnsPost(condition);
			
			//댓글 가져오기
			List<SnsComment> comments = ss.getMapper(SnsMapper.class).getSnsComments(condition);
			
			for (SnsComment snsComment : comments) {
				System.out.println(snsComment.getBsc_txt());
			}
			
			req.setAttribute("page", page);
			req.setAttribute("posts", posts);
			req.setAttribute("comments", comments);
			System.out.println("글: "+allPoatCount);
//			System.out.println(posts.get(0).getBs_txt());
//			System.out.println(posts.get(0).getBs_writer());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	// 총 글수
	public void postCounter() {
		allPoatCount = ss.getMapper(SnsMapper.class).getPostCount();
	}
	
	//글삭제
	public void postDelete(SnsPost sp, HttpServletRequest req,RedirectAttributes re) {
		try {
			System.out.println(req.getParameter("delete"));
			
			sp.setBs_no(new BigDecimal(Integer.parseInt(req.getParameter("delete"))));
			if(ss.getMapper(SnsMapper.class).deletePsot(sp)==1) {
				re.addFlashAttribute("result", "글이 삭제되었습니다.");
				allPoatCount--;
			}
			else {
				re.addFlashAttribute("result", "글 삭제 실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//댓굴  쓰기
	public void writeSnsComment(HttpServletRequest req, SnsComment sc, RedirectAttributes re) {
		try {
			String cToken = req.getParameter("commentToken");
			String lastSucessToken = (String)req.getSession().getAttribute("sucessToken");
			if(lastSucessToken != null && cToken.equals(lastSucessToken)) {
				re.addFlashAttribute("result", "댓글쓰기 실패(새로고침)");
				req.getSession().setAttribute("sucessToken", cToken);
			}
			if(ss.getMapper(SnsMapper.class).snsCommentWriter(sc)==1) {
				re.addFlashAttribute("result", "댓글쓰기 성공");
				req.getSession().setAttribute("sucessToken", cToken);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
