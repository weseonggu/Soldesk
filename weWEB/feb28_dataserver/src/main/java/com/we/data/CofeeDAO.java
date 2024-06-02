package com.we.data;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.we.DBManager.copy.DBManager;

public class CofeeDAO {
	
	//xml 형식
	public static String getData(HttpServletRequest request) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		//대량의 string을 붙일떄 StringBuffer 사용
		StringBuffer sb = new StringBuffer();
		
		try {
			con = DBManager.connectPool("wewe");
			String sql = "select c_name, c_price from feb28_coffee";
			pstmt= con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<feb28_coffee>");
			while(rs.next()) {
				sb.append("<coffee>");
				sb.append("<c_name>"+rs.getString("c_name")+"</c_name>");
				sb.append("<c_price>"+rs.getInt("c_price")+"</c_price>");
				sb.append("</coffee>");
			}
			sb.append("</feb28_coffee>");
			
			
			return sb.toString();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {			
			DBManager.dbClose(con, pstmt, rs);
		}
	}
	
	
	
	
}
