package com.we.jan31.main;
// DAO/DTO패턴
// DAO data Acess object :db관련 작업하는 M
// DTO: DAO에서 작업하고 결과를 DTO로 받는다
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.we.db.manager.DBManager;

public class Back {


	public static String reg(SendInfo ra) {
		Connection con= null;
		PreparedStatement pstmt = null;
		// 일반적으로throws를 쓰는게 맞지만 throws를 쓰면 닫지를 못하고 실패 처리를 멋하니 try catch를 써야 한다.
		try {
			con = DBManager.dbConnect("jdbc:oracle:thin:@192.168.0.170:1521:xe", "we", "3750");
			String sql = "insert into jan30_restarea values(jan30_rest_seq.nextval,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, ra.getN());
			pstmt.setString(2, ra.getD());
			pstmt.setString(3, ra.getL());
			pstmt.setInt(4, ra.getP());
			
			if(pstmt.executeUpdate()==1) {
				return "성공";
			}else {
				return "실패";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return "실패";
		}finally {			
			DBManager.dbClosed(con, pstmt, null);
		}
	}
}
