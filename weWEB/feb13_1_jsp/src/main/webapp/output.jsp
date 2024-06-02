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
int x = Integer.parseInt(request.getParameter("xx"));
int y = Integer.parseInt(request.getParameter("yy"));
int bigger =(x>y) ? x:y;
%>
	<h1><%= bigger %></h1>
</body>
</html>