package com.we.jan31.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.we.db.manager.DBManager;

public class AMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt =null;
		try {
			con = DBManager.dbConnect("jdbc:oracle:thin:@192.168.0.170:1521:xe", "we", "3750");
			System.out.print("지울 상품명: ");
			String p_n=k.next();
			String sql = "delete from jan30_product where p_name like '%'||?||'%'";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,p_n);
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBManager.dbClosed(con, pstmt, null);
		k.close();
	}

}
