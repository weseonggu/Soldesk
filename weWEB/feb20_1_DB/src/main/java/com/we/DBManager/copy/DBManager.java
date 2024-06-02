package com.we.DBManager.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	public static Connection connectPool(String poolName) throws NamingException, SQLException {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+poolName);
		return ds.getConnection();
	}
	
	public static void dbClose(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
		}
		try {
			pstmt.close();
		} catch (Exception e) {
		}
		try {
			con.close();
		} catch (Exception e) {
		}
		
		
	}
}
