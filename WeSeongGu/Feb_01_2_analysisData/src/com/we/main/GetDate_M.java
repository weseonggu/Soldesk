package com.we.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.we.db.manager.DBManager;

public class GetDate_M {
	public static ArrayList<AvgDust>  getDataToDB() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<AvgDust> arr = new ArrayList<>();
		
		try {
			con = DBManager.dbConnect("jdbc:oracle:thin:@192.168.0.170:1521:xe", "we", "3750");
			String sql = "select w_MSRSTE_NM, avg(w_PM10+ w_pm25) as avg_v from FEB01_WEATHER group by w_MSRSTE_NM order by avg(w_PM10+ w_pm25) desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				System.out.println(rs.getString("w_MSRSTE_NM"));
//				System.out.println(rs.getDouble("avg_v"));
				arr.add(new AvgDust(rs.getString("w_MSRSTE_NM"), rs.getDouble("avg_v")));
				
			}
			return arr;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
			DBManager.dbClosed(con, pstmt, rs);
		}
	}
}
