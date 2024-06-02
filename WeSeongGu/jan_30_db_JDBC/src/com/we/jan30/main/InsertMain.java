package com.we.jan30.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) {
		String addr = "jdbc:oracle:thin:@192.168.0.170:1521:xe";
		Scanner k = new Scanner(System.in);

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 연결-------------------------------------------------------
			con = DriverManager.getConnection(addr, "we", "3750");
			System.out.println("연결 성공");
			// 데이터 -----------------------------------------------------
			System.out.print("휴개소이름: ");
			String n =k.next();
			System.out.print("방향: ");
			String s= k.next();
			System.out.print("위치: ");
			String w = k.next();
			System.out.print("주차 대수: ");
			int p = k.nextInt();
			
			// sql---------------------------------------------------------
			// 1) 자바 변수 값 들어갈 자리에 ?로 변경
			// 2) ;빼기
			String sql = "insert into jan30_restarea "+
					"VALUES (jan30_rest_seq.nextval, ?, ?, ?, ?)";
			
			//sql완성, sql을 서버로 전송, 원격 실행, 실행 결과 받아와서.. 
			//를 다해주는 거 (1회용 임) -> PreparedStatement
			pstmt = con.prepareStatement(sql);
			
			//sql완성 ?채우기--------------------------------
			pstmt.setString(1, n);// ( 들어갈 위치 1번부터 시작, 들어갈 변수)
			pstmt.setString(2, s);
			pstmt.setString(3, w);
			pstmt.setInt(4, p);
			
			// sql을 서버로 전송, 원격 실행, 결과 받기 까지 다하는 거
			int row = pstmt.executeUpdate();
			if(row == 1) {
				System.out.println("등록 성공");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 닫는 순서 중요 PreparedStatement닫고 -> Connection닫아야함 무조건 그리고 가자 따로 try문에 있어야함
		// 다른 예외도 잡을 수 있도록 Exception으로 변경
		try { pstmt.close(); } catch (Exception e1) {}
		try {con.close();} catch (Exception e) {}
		k.close();
	}
}
