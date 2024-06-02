package com.we.jan31.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.we.db.manager.DBManager;

public class SelectResult {
	public ArrayList<Product> result_select() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Product> arr = new ArrayList<>();

		try {
			con = DBManager.dbConnect("jdbc:oracle:thin:@192.168.0.170:1521:xe", "we", "3750");
			String sql = "select p_name , p_price from jan30_product order by p_name, p_price";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				arr.add(new Product(rs.getString("p_name"), rs.getInt("p_price")));
			}
			return arr;

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		} finally {
			DBManager.dbClosed(con, pstmt, rs);
		}
	}
	public static ArrayList<CateCount> select_cate() {
		ArrayList<CateCount> arr = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.dbConnect("jdbc:oracle:thin:@192.168.0.170:1521:xe", "we", "3750");
			String sql = "select p_cate, count(p_name) as cp from jan30_product group by p_cate";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				arr.add(new CateCount(rs.getString("p_cate"), rs.getInt("cp")));
			}
			return arr;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBManager.dbClosed(con, pstmt, rs);
		}
		
	}
}
