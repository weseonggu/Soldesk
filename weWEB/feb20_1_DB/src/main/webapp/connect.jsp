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
	// Oracle DB �� ���� �Ϸ��� ojdb8.jar������ �ʿ�,
	// Oracle od = new Ora.... ó�� ����� ���°� �ƴϰ�
	// �ڹٰ� �˼� ���� ���
		Connection con= null;
		try{
			//����Ŀ���� ����� �޶�
			// �ּҸ� ���� ����Ŭ�̴� �� �� ����
			// -> �˾Ƽ� OracleDriver�� ���� ��
			// ������ jspȯ�濡���� �ڵ����� ���� �׷��� oracleDriver�� ����� �˷� �����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url ="jdbc:oracle:thin:@192.168.0.170:1521:xe";
			con = DriverManager.getConnection(url, "we", "3750");
			%>
			<h1>����</h1>
			<%
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</body>
</html>