package com.we.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.we.DBManager.copy.DBManager;

public class CofeeDAO {
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
			System.out.println(rs.next());
			sb.append("<>?xml version=\"1.0\" encoding=\"UTF-8\"?");
			sb.append("<feb28_coffee>");
			while(rs.next()) {
				sb.append(rs.getString("c_name"));
				sb.append(rs.getInt("c_price"));
			}
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
