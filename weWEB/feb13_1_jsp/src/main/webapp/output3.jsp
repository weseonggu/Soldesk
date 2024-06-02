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
int dan = Integer.parseInt(request.getParameter("dan"));
%>

<table border ="1">
<tr>
<td align="center">
	<%= dan %>단
</td>
</tr>
<%for(int i = 2;i<10 ;i++){ %>
<tr>
<td>
	<%= dan %>*<%= i %>=<%= dan*i %>
</td>
</tr>
<%} %>

</table>
</body>
</html>