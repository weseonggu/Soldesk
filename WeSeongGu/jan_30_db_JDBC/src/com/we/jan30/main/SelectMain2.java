package com.we.jan30.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String addr = "jdbc:oracle:thin:@192.168.0.170:1521:xe";
		Scanner k = new Scanner(System.in);

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// select 결과 list에 가까움 set이라 생각x
		try {
			// 연결-------------------------------------------------------
			con = DriverManager.getConnection(addr, "we", "3750");
			System.out.println("연결 성공");

			String sql = "select p_cate, avg(p_price) as avg from jan30_product group by p_cate";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			// rs : 사이즈를 모름
			// rs.next(); 
			//			다음 데이터로 
			//			갔는데 없으면 false
			while(rs.next()) {
				System.out.print(rs.getString("p_cate")+" ");
				System.out.println(rs.getInt("avg"));
				System.out.println("------------");
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
