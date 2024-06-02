package com.we.main;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InsertMain {

	public static void main(String[] args) {
		SqlSession ss=null;
		Scanner sc  = new Scanner(System.in);
		try {
			InputStream is = Resources.getResourceAsStream("DBSetting.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			ss=ssf.openSession();// 한번만 해야함 여러번 하면 새로운 연결임
			
			System.out.print("뭐 ");
			String name = sc.next();
			System.out.print("가격 ");
			BigDecimal price  = sc.nextBigDecimal();
			Coffee c =  new Coffee(name, price);
			
			if(ss.insert("coffeeMapper.inertCoffee", c)==1) {
				// 1이 나오면 성공
				System.out.println("성공");
				ss.commit();// DB에 반영
			}else {
				//ss.rollback();// DB에 반영 안함				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
		sc.close();
	}

}
