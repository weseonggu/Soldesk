<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="AddController" name="addInput"
	onsubmit="return addCheck();"
	method="post">
		<textarea rows="" cols="" name="num"></textarea><br>
		<button>계산</button>
	</form>
</body>
</html>