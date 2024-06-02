package com.we.main;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBaticsAMain {

	public static void main(String[] args) {
		
		SqlSession ss=null;
		try {// 예외 처리 필요 없음 확인 차 하는거임
			InputStream is = Resources.getResourceAsStream("DBSetting.xml");
			
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss=ssf.openSession();
			System.out.println("성공");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}

}
