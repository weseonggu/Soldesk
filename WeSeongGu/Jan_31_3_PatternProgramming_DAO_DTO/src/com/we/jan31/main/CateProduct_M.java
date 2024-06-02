package com.we.jan31.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.we.db.manager.DBManager;

public class CateProduct_M {
	public void select_cate() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.dbConnect("jdbc:oracle:thin:@192.168.0.170:1521:xe", "we", "3750");
			String sql = "select p_cate count(p_name) from jan30_product group by p_cate";
			pstmt = con.prepareStatement(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
