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
	//자동이동 second ->third 자동 이동
	int a = Integer.parseInt(request.getParameter("a"));
	int b = Integer.parseInt(request.getParameter("b"));
	int c =a+b;
	//자동이동 second ->third 자동 이동
	//		second는 안보이고 third로 이동
	// 1. redirect
	//		response.sendRedirect("third.jsp");
	// 2. forward
 	RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
	// 3. 자바에서 만든 데이터도 third로 넘기는 방법
	request.setAttribute("c", c);// 기본형을 자도응로 형변환 함 
	request.setAttribute("v", 234);
	Random r =new Random();
	request.setAttribute("r", r);
	//rd.forward(request, response);
	// 4. include (위치 조절 불가능)
	rd.include(request, response);
	%>

	<h1>second</h1>
	<%=a%>
	<%=b%>
</body>
</html>