<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<!-- 모바일 최적화 -->
<meta name="viewport" content="width=device-width">
<title>Insert title here</title>
<link rel="stylesheet" href="css/outputStyle.css">
</head>
<body>
<h1>가위 바위 보 게임</h1>
	<div id ="total">
		<div id = "pick">
			<a href="HomeController?put=1"> 
			<img src="img/1.png">
			</a> <a href="HomeController?put=2">
			<img src="img/2.png">
			</a> <a href="HomeController?put=3"> 
			<img src="img/3.png">
			</a><br>
		</div>
		<div id = "result">
		<div id = "see">
			<span>컴퓨터</span>
			<span>vs</span>
			<span>유저</span>
		</div>
		<div id = "put">
			<div><img src="img/${pc }.png"></div>
			<div><img src="img/${user }.png"></div>
		</div>
		<div id = "result">
			<h2>결과: ${result }</h2>
		</div>
		</div>
	</div>
</body>
</html>