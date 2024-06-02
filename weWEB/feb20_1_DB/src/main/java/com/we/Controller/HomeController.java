package com.we.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }
    // JAVA +DB연결하는데 쓰는 기술
    //오리지날 jdbc : DB서버랑 연결 해달라 하면
    //				그떄 부터 세팅하고, 뭐하고....
    //				con을 만들어주는 느낌 -> 느림
    
    
    //ConnectionPool: con을 미리 몇 개 만들어 놓고
    //				  DB서버랑 녀결해달라 하면
    //				  만들어놓은거 주면 끝 -> 빠름
    //				  톰캣이 함 그냥 자바는 못함
    // META-INF는  그 프로젝트에만 적용되는 톰캣 설정파일 넣는 폴더 (DB서버주소 저장하는거)
    
    // ???(하나더 있음)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con =null;
		try {
			// 튜브대여소 설계도 : context.xml
			// 톰캣의 설정 파일: 다양한거 등록하고 사용 가능
			Context ctx = new InitialContext();
			
			// 튜브대여소
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/wewe");//java:comp/env/찾을거이름 
							//형변환 해야함
			
			// 튜브 : Connection
			con = ds.getConnection();
			System.out.println("연결성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
