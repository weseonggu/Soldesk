package com.we.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.we.db.manager.DBManager;
import com.we.needclass.Product;
import com.we.needclass.Search;
import com.we.needclass.StoreData;

// DAO는 객체를 만들어야 하고
// 여러개가 필요하지는 않고,
// 여러개가 되면 곤란 -> 메모리 낭비..
// singleton 패턴
public class DAO {

	private static final String dbAddr = "jdbc:oracle:thin:@192.168.0.170:1521:xe";
	private static final String id = "we";
	private static final String pw = "3750";
	// 2. 내부에서 만들어서 고정
	private static final DAO CDHO = new DAO();

	private int snackCount;

	// singleton pattern
	// 1. 외부에서 객체를 못만 들게 private로 설정
	private DAO() {
		snackCount = countSnack();
	}

	public static DAO getCdho() {
		return CDHO;
	}

	// 1번 3번 4번
	public int getAllPage() {
		int n = (int) Math.ceil(snackCount / 3.0);
		return n;
	}

	// 내부에서 사용
	private int countSnack() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.dbConnect(dbAddr, id, pw);
			String sql = "select count(*)as c from CONVENIENCE_STORE, STORE_PRODUCT where c_no = s_c_no ";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("c");

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
			// TODO: handle exception
		} finally {
			DBManager.dbClosed(con, pstmt, rs);
		}

	}

	// 1번
	public String insertCVS(StoreData s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.dbConnect(dbAddr, id, pw);
			String sql = "insert into convenience_store values(convenience_store_seq.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getBrand());
			pstmt.setString(2, s.getJijum());
			pstmt.setString(3, s.getLoction());

			if (pstmt.executeUpdate() == 1) {
				return "성공";
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "실패";
		} finally {
			DBManager.dbClosed(con, pstmt, null);
		}
	}

	// 2번
	public String insertProduct(Product p) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.dbConnect(dbAddr, id, pw);
			String sql = "insert into store_product values (store_product_seq.nextval, to_date(?,'YYYY-MM-DD'), ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p.getExp());
			pstmt.setString(2, p.getName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setInt(4, p.getCvs());

			if (pstmt.executeUpdate() == 1) {
				this.snackCount++;
				return "성공";
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "실패";
		} finally {
			DBManager.dbClosed(con, pstmt, null);
		}
	}

	// 2번
	public ArrayList<StoreData> cvsNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StoreData> arr = new ArrayList<>();
		try {
			con = DBManager.dbConnect(dbAddr, id, pw);
			String sql = "select c_jijum, c_no from convenience_store";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				arr.add(new StoreData(rs.getString("c_jijum"), rs.getInt("c_no")));
			}
			return arr;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBManager.dbClosed(con, pstmt, rs);
		}
	}

	// 3번
	public ArrayList<Search> selectAll(int page) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Search> arr = new ArrayList<>();

		try {
			con = DBManager.dbConnect(dbAddr, id, pw);
			String sql = "select * from(\r\n"
					+ "	select rownum as rn, c_brand, c_jijum, c_location, s_exp, s_name, s_price from(\r\n"
					+ "		select * from CONVENIENCE_STORE, STORE_PRODUCT \r\n" + "		where c_no = s_c_no \r\n"
					+ "		order by c_brand, c_jijum,c_jijum,s_name,c_location\r\n" + "	)\r\n" + ")\r\n"
					+ "where rn>= ? and rn <= ?";
			pstmt = con.prepareStatement(sql);
			int end = page * 3;
			pstmt.setInt(1, end - 2);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				arr.add(new Search(rs.getString("c_brand"), rs.getString("c_jijum"), rs.getString("c_location"),
						rs.getString("s_exp"), rs.getString("s_name"), rs.getInt("s_price")));
			}
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		} finally {
			DBManager.dbClosed(con, pstmt, rs);
		}
	}

	// 4번
	public ArrayList<Search> selectSnack(int page) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Search> arr = new ArrayList<>();

		try {
			con = DBManager.dbConnect(dbAddr, id, pw);
			String sql = "select * from(\r\n" + "	select rownum as rn, s_exp, s_name, s_price from(\r\n"
					+ "		select * from STORE_PRODUCT \r\n" + "	)\r\n" + ")\r\n" + "where rn>=? and rn <=? ";
			pstmt = con.prepareStatement(sql);
			int end = page * 3;
			pstmt.setInt(1, end - 2);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				arr.add(new Search(rs.getString("s_exp"), rs.getString("s_name"), rs.getInt("s_price")));
			}
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		} finally {
			DBManager.dbClosed(con, pstmt, rs);
		}
	}

	// 5번
	public ArrayList<Search> cvsAddr(int p, String a) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Search> arr = new ArrayList<>();
		try {
			con = DBManager.dbConnect(dbAddr, id, pw);
			String sql = "select * from(\r\n" + "	select rownum as rn, c_brand, c_jijum, c_no, c_location from(\r\n"
					+ "		select c_brand, c_jijum, c_no, c_location \r\n" + "		from convenience_store\r\n"
					+ "		where c_location like '%'||?||'%' \r\n" + "	)\r\n" + ")\r\n" + "where rn>=? and rn <=?";
			pstmt = con.prepareStatement(sql);
			int end = p * 3;
			pstmt.setString(1, a);
			pstmt.setInt(2, end - 2);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				arr.add(new Search(rs.getInt("c_no"), rs.getString("c_brand"), rs.getString("c_jijum"),
						rs.getString("c_location")));
			}
			return arr;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBManager.dbClosed(con, pstmt, rs);
		}
	}

	// 5번
	public int searchCSVCount(String a) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.dbConnect(dbAddr, id, pw);
			String sql = "select count(*) as c from convenience_store " + "where c_location like '%'||?||'%' ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, a);

			rs = pstmt.executeQuery();
			int allPage = 0;
			while (rs.next()) {
				allPage = rs.getInt("c");
				allPage = (int) Math.ceil(allPage / 3.0);
			}

			return allPage;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		} finally {
			DBManager.dbClosed(con, pstmt, rs);
		}
	}

	// 6번
	public int searchProduct(String n) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.dbConnect(dbAddr, id, pw);
			String sql = "select count (*) as c from STORE_PRODUCT where s_name like '%'||?||'%' ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("c");

		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		} finally {
			DBManager.dbClosed(con, pstmt, rs);
		}
	}

	// 6번
	public ArrayList<Search> productNameLocation(int p, String pName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Search> arr = new ArrayList<>();
		try {
			con = DBManager.dbConnect(dbAddr, id, pw);
			String sql = "select * from(\r\n" + "	select rownum as rn, c_brand, c_jijum, s_name, s_price from(\r\n"
					+ "		select * from CONVENIENCE_STORE, STORE_PRODUCT \r\n"
					+ "		where c_no = s_c_no and s_name like '%'||?||'%'\r\n" + "	) \r\n"
					+ ") where rn>=? and rn <=?";
			int end = p * 3;

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pName);
			pstmt.setInt(2, end - 2);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				arr.add(new Search(rs.getString("c_brand"), rs.getString("c_jijum"), rs.getString("s_name"),
						rs.getInt("s_price")));
			}
			return arr;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
