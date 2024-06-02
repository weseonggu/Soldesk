<%@page import="oracle.jdbc.driver.OracleDriver"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.net.ConnectException"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	// Oracle DB 랑 연결 하려면 ojdb8.jar파일이 필요,
	// Oracle od = new Ora.... 처럼 만들어 쓰는게 아니고
	// 자바가 알서 만들어서 사용
		Connection con= null;
		try{
			//메이커별로 양식이 달라서
			// 주소만 봐도 오라클이다 알 수 없음
			// -> 알아서 OracleDriver을 만들어서 씀
			// 하지만 jsp환경에서는 자동으로 못함 그래서 oracleDriver을 쓰라고 알려 줘야함
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url ="jdbc:oracle:thin:@192.168.0.170:1521:xe";
			con = DriverManager.getConnection(url, "we", "3750");
			%>
			<h1>성공</h1>
			<%
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</body>
</html>