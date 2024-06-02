<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%
double data = Double.parseDouble(request.getParameter("data"));
String danwe = request.getParameter("danwe");
String input =null;
String result= null;
String color = null;
if(danwe.equals("inch")){
	input = Double.toString(data) + " cm";
	result=Double.toString(Math.round((data/2.54)*10)/10.0)+" inch";
	color= "red";
}else if(danwe.equals("pung")){
	input = Double.toString(data) + " ㎡";
	result=Double.toString(Math.round((data*0.3025)*10)/10.0)+" 평";
	color = "blue";
}else if(danwe.equals("mi")){
	input = Double.toString(data) + " km/h";
	result=Double.toString(Math.round((data/1.609344)*10)/10.0)+" mi/h";
	color = "gray";
}else if(danwe.equals("f")){
	input = Double.toString(data) + " ℃";
	result=Double.toString(Math.round((32+(1.8*data))*10)/10.0)+" ℉";
	color = "orange";
}
response.sendRedirect("test.html");// 응답을 넘김
%>

<style>
table{
	border : solid 3px <%=color %>;
	background-color: white;	
	margin: auto;
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

<table width ="300px" height="180px">

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