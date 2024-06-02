<%@page import="com.we.main.Guest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/ouputStyle.css">

<%
Guest g = (Guest) request.getAttribute("guest");

String name =g.getName();
double h= g.getH();
double w = g.getW();
String fname = g.getFname();
double bmi = g.getBmi();
String result = g.getResult();
%>
</head>
<body>
	<table>
		<tr>
			<td align="center" colspan="2"><h3>결과</h3></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><img src="img/<%=fname%>"></td>
		</tr>
		<tr>
			<td align="center">이름</td>
			<td align="center"><%=name %></td>
		</tr>
		<tr>
			<td align="center">키</td>
			<td align="center"><%=h%></td>
		</tr>
		<tr>
			<td align="center">몸무게</td>
			<td align="center"><%=w%></td>
		</tr>
		<tr>
			<td align="center">BMI</td>
			<td align="center"><%=bmi%></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><%=result%></td>
		</tr>
	</table>
</body>
</html>