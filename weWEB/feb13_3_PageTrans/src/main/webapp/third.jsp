<%@page import="java.util.Random"%>
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
	int a = Integer.parseInt(request.getParameter("a"));
	int b = Integer.parseInt(request.getParameter("b"));
	//forward�� first���� second���� �� ������ (�ַ����� ���)
	//redirect�� ���� third���� �ȿ�
	
	//java���� ������� ��(sencond�� c) �ѱ�� ���
	// request  attribute
	//	object�� �� �ѱ� �� ����
	//  request �Ҽ���
	//  ������ �ޱ�
	Object ob =request.getAttribute("c");
	Integer aa = (Integer) ob;
	int aaa = aa.intValue();
	// �� ���ٷ� �ۼ�
	int v= (Integer)request.getAttribute("v");
	Random r = (Random)request.getAttribute("r");
	int num = r.nextInt();
	%>
	<h1>third</h1>
	<%=a%>
	<%=b%>
	<%=aaa%>
	<%=v%>
	<%=num%>
</body>
</html>