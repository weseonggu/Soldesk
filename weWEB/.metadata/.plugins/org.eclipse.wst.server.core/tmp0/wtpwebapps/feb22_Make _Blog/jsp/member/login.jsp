<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src = "js/weValidCheck.js"></script>
<script type="text/javascript" src = "js/loginCheck.js"></script>
</head>
<body>
	<form action="LoginController" method="post" onsubmit="return loginCheck();"
	name = "loginForm" id = "loginForm">
		<span>id: <input name="id"></span>
		<span>pw: <input name="pw"></span><br>
		<div>
			<button>�α���</button>
			<a href="JoinController">ȸ������</a>
		</div>
	</form>
</body>
</html>