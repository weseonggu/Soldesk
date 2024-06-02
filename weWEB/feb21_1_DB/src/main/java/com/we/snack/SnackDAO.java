package com.we.snack;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import com.we.DBManager.copy.DBManager;

public class SnackDAO {
	private static final SnackDAO SDAO = new SnackDAO();

	private SnackDAO() {
		// TODO Auto-generated constructor stub
	}

	public static SnackDAO getSdao() {
		return SDAO;
	}
	
	public void reg(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			// DB연결
			con = DBManager.connectPool("wewe");
			System.out.println("연결성공");
			// 데이터 확보
			request.setCharacterEncoding("euc-kr");
			String name = request.getParameter("n");
			int price = Integer.parseInt(request.getParameter("p"));
			
			System.out.println(name);
			System.out.println(price);
			
			//sql(미완성)
			String sql = "insert into feb21_snack VALUES(feb21_snack_seq.NEXTVAL, ?, ?)";
			
			//DB관련 총괄 매니저 객체
			pstmt = con.prepareStatement(sql);

			//sql완성
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			
			//실행 & 결과 처리
			int row = pstmt.executeUpdate();
			if(row == 1) {
				System.out.println("등록 성공");
				request.setAttribute("result", "등록성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBManager.dbClose(con, pstmt, null);
	}
	
	
	
	
	public void get(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SnackInfo> arr = new ArrayList<>(); 
		
		try {
			con=DBManager.connectPool("wewe");
			
			String spl = "select * from feb21_snack";
			
			pstmt = con.prepareStatement(spl);
			
			rs = pstmt.executeQuery();
			SnackInfo s = null;
			while(rs.next()){
				s=  new SnackInfo();
				s.setS_no(rs.getInt("s_no"));
				s.setS_name(rs.getString("s_name"));
				s.setS_price(rs.getInt("s_price"));
				arr.add(s);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		DBManager.dbClose(con, pstmt, rs);
		req.setAttribute("SnackData", arr);
	}

}
