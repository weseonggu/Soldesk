package com.we.main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMain {
	public static void main(String[] args) {
		SqlSession ss=null;
		try {
			InputStream is = Resources.getResourceAsStream("DBSetting.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			ss=ssf.openSession();
			
			List<Coffee> coffees = ss.selectList("coffeeMapper.getCoffee");
			
			for (Coffee c : coffees) {
				System.out.println(c.getC_name());
				System.out.println(c.getC_price());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}

}
