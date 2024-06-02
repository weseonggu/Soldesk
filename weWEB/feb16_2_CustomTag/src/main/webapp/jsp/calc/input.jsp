<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>덧셈</h1>
	<form action="Menu2Controller" id ="inputForm"
	onsubmit = "return calcCheck();"
	name = "calcForm"
	method="get">
	x:<input name="xxx" type ="number"><br>
	y:<input name="yyy" type = "number"><br>
	<button>계산</button>
	</form>
</body>
</html>