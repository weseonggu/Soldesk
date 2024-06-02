<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<form action = "SnackController">
 	이름: <input name = "snackName"><br>
 	가격: <input name = "snackPrice"><br>
 	유통기한: <input name = "snackExp"><br>
 	<button>등록</button>
 	</form>
 	
 	<table border="1">
 		<tr>
 		<td>번호</td>
 		<td>이름</td>
 		<td>가격</td>
 		<td>유통기한</td>
 		</tr>
 		<c:forEach var="s" items="${snacks }">
	 		<tr>
	 		<td>${s.s_no }</td>
	 		<td>${s.s_name}</td>
	 		<td>
	 		<fmt:formatNumber value="${s.s_price}" type="number"/>
	 		</td>
	 		<td>
	 		<fmt:formatDate value="${s.s_exp}" type="date"/>
	 		</td>
	 		</tr>
 		</c:forEach>
 		<tr>
 		<td align="center" colspan="4">
 		<c:forEach var="p" begin="1" end="${page }">
 		<a href= "HomeController?p=${p }">${p }</a>
 		</c:forEach>
 		</td>
 		</tr>
 		
 		 <tr>
 		<td align="center" colspan="4">
 		<form action="SnackSearchController">
 			<input name ="search">
	 		<button>검색</button>
 		</form>
 		</td>
 		</tr>
 		
 	</table>
</body>
</html>