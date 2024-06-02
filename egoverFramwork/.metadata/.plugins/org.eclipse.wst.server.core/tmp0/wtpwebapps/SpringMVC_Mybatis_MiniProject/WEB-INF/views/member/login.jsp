<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/loginCheck.js"></script>
<link rel="stylesheet" href="resources/css/loginStyle.css">
</head>
<body>
	<a id = "signin" href="signUp.menber">회원가입</a>
	<form id ="login"action="member.login" method="post" name="loginForm"
	onsubmit="return loginCheck();">
		<input placeholder="id" name="bm_id">
		<input placeholder="pw" name="bm_pw">
		<button>로그인</button>
	</form>
</body>
</html>