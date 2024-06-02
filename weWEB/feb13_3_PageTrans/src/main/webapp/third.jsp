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
	//forward는 first값이 second까지 옴 하지만 (주력으로 사용)
	//redirect는 값이 third까지 안옴
	
	//java에서 만들어진 값(sencond의 c) 넘기는 방법
	// request  attribute
	//	object면 다 넘길 수 있음
	//  request 소속임
	//  데이터 받기
	Object ob =request.getAttribute("c");
	Integer aa = (Integer) ob;
	int aaa = aa.intValue();
	// 위 한줄로 작성
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