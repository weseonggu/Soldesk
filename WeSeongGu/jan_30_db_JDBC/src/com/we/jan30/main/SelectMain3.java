package com.we.jan30.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectMain3 {
	public static void main(String[] args) {
		String addr = "jdbc:oracle:thin:@192.168.0.170:1521:xe";
		Scanner k = new Scanner(System.in);
		
		Connection con = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(addr,"we","3750");
			System.out.print("찾을 휴개소이름: ");
			String n =k.next();
			String sql = "select * from jan30_restarea where r_name like '%'||?||'%'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("r_no"));
				System.out.println(rs.getString("r_name"));
				System.out.println(rs.getString("r_direction"));
				System.out.println(rs.getString("r_location"));
				System.out.println(rs.getString("r_park"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try { rs.close(); } catch (Exception e2) {}
		try { pstmt.close(); } catch (Exception e1) {}
		try {con.close();} catch (Exception e) {}
		k.close();
	}
}
