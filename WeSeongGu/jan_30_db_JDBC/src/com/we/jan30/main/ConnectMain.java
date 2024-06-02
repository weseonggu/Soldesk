package com.we.jan30.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

// java 프로그램 + 오라클 db연결
// DB통신: 자바에 없음 메이커가 너무 다양해서, 통신 방식이 완전 다른 정도는 아니고
// 최종적으로 db서버에 연결하기 위한 드라이버가 다름

// ojdbc8.jar에 oracleDriver가 있음
public class ConnectMain {

	public static void main(String[] args) {
		// 연결할 db서버 주소 [db메이커별로 폼이 다 다름]
		// data source explorer -> db우클릭 -> properties -> driver properties -> connection url
		String addr ="jdbc:oracle:thin:@192.168.0.170:1521:xe";
		
		Connection con = null;
		try {
			
			// 최종적으로 연결 할 때 OracleDriver사용하도록
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");// 자동으로 사용함 적을 필요 없음 jsp할때는 적어야함
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
			con = DriverManager.getConnection(addr,"we","3750");
			System.out.println("연결 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			con.close();// 연결 종료
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
