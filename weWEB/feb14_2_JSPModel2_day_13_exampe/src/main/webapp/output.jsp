<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%
/* String d = request.getParameter("data"); */
String input =request.getParameter("input");
String result= request.getParameter("result");
String color = request.getParameter("color");

%>

<style>
table{
	border : solid 3px <%=color %>;
	background-color: white;	
	margin: auto;
	width : 300px;
	height : 180px;
}
tr:nth-child(1) td{
	background-color: <%=color %>;
	margin : 0px;
	color: white;
	padding: 0px;
}
td{
	padding : 0px;
}
</style>
</head>
<body>

<table>

<tr>
<td align="center">
변환값
</td>
</tr>

<tr>
<td align="center">
	<%=input %>
</td>
</tr>

<tr>
<td align="center">
	↓
</td>
</tr>
<tr>
<td align="center">
	<%=result %>
</td>
</tr>
</table>

</body>
</html>

<!-- 프론트엔드 --> 