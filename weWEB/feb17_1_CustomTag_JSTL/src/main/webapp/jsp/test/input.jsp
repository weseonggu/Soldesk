<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<h1>����</h1>
	<form action="TestController" method="get"
	name = "inputForm"
	onsubmit="return testCheck();">
	<input name="n"><br>
	<button id = "inputBTN">Ȯ��</button>
	</form>
</body>
</html>