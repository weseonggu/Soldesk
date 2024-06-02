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
int x = Integer.parseInt(request.getParameter("x"));
int y = Integer.parseInt(request.getParameter("y"));
int hub = x+y;
int sub = x-y;
int gub =x*y;
int dis = x/y;
%>
	<table border="1">
	<tr>
		<td>
			<%= hub %>
		</td>
	</tr>
	<tr>
		<td>
			<%= sub %>
		</td>
	</tr>
	<tr>
		<td>
			<%= gub %>
		</td>
	</tr>
	<tr>
		<td>
			<%= dis %>
		</td>
	</tr>
	</table>
</body>
</html>