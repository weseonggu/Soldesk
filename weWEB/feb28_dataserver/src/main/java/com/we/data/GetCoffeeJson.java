package com.we.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.we.DBManager.copy.DBManager;

public class GetCoffeeJson {
	//json 형식
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
			
			
			rs.next();
			sb.append("[");
			while(true) {
				sb.append("{");
				sb.append("\"c_name\":\""+rs.getString("c_name")+"\",");
				sb.append("\"c_price\":"+rs.getInt("c_price"));
				if(rs.next()== false) {
					sb.append("}");
					break;
				}
				else {
					sb.append("},");					
				}
			}
			sb.append("]");
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
