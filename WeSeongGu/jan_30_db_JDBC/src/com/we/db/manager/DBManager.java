package com.we.db.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	/**
	 * 
	 * @param addr  data source explorer -> db_RightClick -> properties -> driver properties -> connection url
	 * @param id Data Base ID
	 * @param pw Data Base Passward
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection dbConnect(String addr, String id, String pw) throws SQLException {
		return DriverManager.getConnection(addr, id, pw);
	}
	/**
	 * 
	 * @param con Connection's object
	 * @param pstmt PreparedStatement's object
	 * @param rs ResultSet's object
	 */
	public static void dbClosed(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e2) {
		}
		try {
			pstmt.close();
		} catch (Exception e1) {
		}
		try {
			con.close();
		} catch (Exception e) {
		}
	}
}
