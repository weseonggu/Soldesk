<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	<form action = "MemberController" method="post">
	id: <input name = "id" value="${cookie.loginID.value }"><br>
	pw: <input name = "pw"><br>
	<button>로그인</button>
	</form>
</body>
</html>