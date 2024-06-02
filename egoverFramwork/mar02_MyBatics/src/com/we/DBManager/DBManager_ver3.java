package com.we.DBManager;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBManager_ver3 {
	private SqlSessionFactory ssf;
	private static final DBManager_ver3 DBM = new DBManager_ver3();

	private DBManager_ver3() {
		
	}

	public static DBManager_ver3 getDbm() {
		return DBM;
	}

	public void setFacory(String config) {
		try {
			InputStream inputStream = Resources.getResourceAsStream(config);
			ssf = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SqlSessionFactory getSsf() {
		return ssf;
	}

}
