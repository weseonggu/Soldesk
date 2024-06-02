<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="js/weValidCheck.js"></script>
<script type="text/javascript" src="js/check.js"></script>
</head>
<body>
	<form action="SnackController" method="post" onsubmit="return check();"
		name="f">
		<input name="n" maxlength="10" autofocus="autofocus"><br>
		<input name="p" maxlength="5" type="number"><br>
		<button>확인</button>
	</form>
	<hr>
	${result }
	<hr>
	<table border="1">
		<c:forEach var="snack" items="${SnackData }">
			<tr>
				<td>${snack.s_no }</td>
				<td>${snack.s_name }</td>
				<td><fmt:formatNumber value="${snack.s_price }" type="number"/> </td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>