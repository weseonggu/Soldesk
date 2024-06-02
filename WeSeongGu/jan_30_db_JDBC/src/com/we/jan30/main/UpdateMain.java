package com.we.jan30.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String addr = "jdbc:oracle:thin:@192.168.0.170:1521:xe";
		Scanner k = new Scanner(System.in);

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 연결-------------------------------------------------------
			con = DriverManager.getConnection(addr, "we", "3750");
			System.out.println("연결 성공");
			// 데이터 -----------------------------------------------------
			System.out.print("찾을 휴개소이름: ");
			String n =k.next();
			System.out.print("변경할 주차 대수: ");
			int p = k.nextInt();
			
			System.out.println("1");

			String sql = "update jan30_restarea set r_park = ? where r_name like ?";
			

			pstmt = con.prepareStatement(sql);
			

			System.out.println("2");
			
			pstmt.setInt(1, p);
			pstmt.setString(2, "%"+n+"%");
			System.out.println("3");
			
			int row = pstmt.executeUpdate();// 안동입력시 작동을 안함 그럼 그냥 껐다가 그냥 다시 키면 된다고함
			// row = 영향 받은 행
			System.out.println("4");
			System.out.println("변경: "+row);
			if(row == 1) {
				System.out.println("등록 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try { pstmt.close(); } catch (Exception e1) {}
		try {con.close();} catch (Exception e) {}
		k.close();
	}

}
