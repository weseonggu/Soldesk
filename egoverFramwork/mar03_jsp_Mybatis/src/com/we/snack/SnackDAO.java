package com.we.snack;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.we.DBManager.DBManager_ver3;

public class SnackDAO {
	private static final SnackDAO SDAO = new SnackDAO();
	private int allSnackCount;
	private int snackPerPage;

	private SnackDAO() {
		snackPerPage=5;
	}

	public static SnackDAO getSdao() {
		return SDAO;
	}

	// 데이터 추가
	public void reg(HttpServletRequest request) {
		SqlSession ss = null;
		try {
			ss = DBManager_ver3.getDbm().getSsf().openSession();
			String name = request.getParameter("snackName");
			int price = Integer.parseInt(request.getParameter("snackPrice"));
			String exp = request.getParameter("snackExp");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");

			Snack s = new Snack();
			s.setS_name(name);
			s.setS_price(new BigDecimal(price));
			s.setS_exp(sdf.parse(exp));

			if (ss.insert("snackMapper.insert", s) == 1) {
				allSnackCount++;
				ss.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DB데이터 거져오기
	public void get(String page, HttpServletRequest request) {
		SqlSession ss = null;
		try {
			ss = DBManager_ver3.getDbm().getSsf().openSession();
			int snackCount = allSnackCount;
			int totalPage =(int) Math.ceil( (double)snackCount/snackPerPage);
			request.setAttribute("page", totalPage);
			int end = Integer.parseInt(page) * snackPerPage;
			int start = end-(snackPerPage-1);
			
			String search = (String) request.getSession().getAttribute("search");
			if(search == null) {
				search ="";
			}
			System.out.println("검색:	"+search);
			
			HashMap<String, String> hm = new HashMap<>();
			hm.put("start", start+"");
			hm.put("end", end+"");
			hm.put("search", search);
			
			List<Snack> snacks = ss.selectList("snackMapper.selectPage",hm);
			
			request.setAttribute("snacks", snacks);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}

	// 데이터 수 가져오기
	public void getCount() {
		SqlSession ss = null;
		try {
			ss = DBManager_ver3.getDbm().getSsf().openSession();
			allSnackCount = ss.selectOne("snackMapper.count");
			System.out.println("수: " + allSnackCount);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
