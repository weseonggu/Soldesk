<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel = "stylesheet" href = "css/outputStyle.css">
<script src = "js/output.js"></script>
<script src = "js/weValidCheck.js"></script>
</head>
<body>
<div id = "total">
	<h1>숫자 야구 게임</h1>
	<form action="HomeController" 
	onsubmit = "return check();"
	name = "fff">
		<input name=swing autofocus="autofocus" type = "number"><br>
		<span>전에 쓴 숫자: ${param.swing }</span><br> 
		<span>s: ${sss}</span><br>
		<span>b: ${bbb}</span><br> 
		<span>tun : ${ttt }</span><br>
		<button>go</button>
	</form>
</div>

<h1>${hhh }</h1>
</body>
</html>