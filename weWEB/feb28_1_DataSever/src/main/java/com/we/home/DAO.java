package com.we.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.we.DBManager.copy.DBManager;

public class DAO {
	private static final DAO dao = new DAO();
	
	private DAO() {
		// TODO Auto-generated constructor stub
	}

	public static DAO getDao() {
		return dao;
	}
	
	public void getData(HttpServletRequest request) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		ArrayList<data> arr = new ArrayList<>();
		
		try {
			con = DBManager.connectPool("wewe");
			String sql = "select c_name, c_price from feb28_coffee";
			pstmt= con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(rs.next());
			while(rs.next()) {
				System.out.println(rs.getString("c_name"));
				System.out.println(rs.getInt("c_price"));
				arr.add(new data(rs.getString("c_name"), rs.getInt("c_price")));
			}
			// 웹사이트랑 상관없는 외부인에게 데이터를 주자 json, xml
			request.setAttribute("arr", arr);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DBManager.dbClose(con, pstmt, rs);
	}
}
