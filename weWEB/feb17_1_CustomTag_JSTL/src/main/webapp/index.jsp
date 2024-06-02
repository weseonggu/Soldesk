<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" href="css/indexStyle.css">
<link rel="stylesheet" href="css/testStyle.css">
<link rel="stylesheet" href="css/lottoStyle.css">
<link rel="stylesheet" href="css/weatherStyle.css">
<script type="text/javascript" src = "js/weValidCheck.js"></script>
<script type="text/javascript" src = "js/feb17check.js"></script>

</head>
<body id = "indexBody">
	<div id="indexArea">
		<div id="siteTitle">
			<a href = "HomeController"><h1>FEB17~20(금~월)</h1></a>
		</div>
		<div id = "mainMenu">
			<div>
				<a href="TestController">연습</a>
				<a href="AddController">합 구하기</a>
				<a href="LottoController">로또</a>
				<a href="JSTLController">JSTL</a>
				<a href="WeatherController">날씨</a>				
				<a href="JSTLFormatingController">JSTL-formating</a>				
				<a href="BookController">책 검색</a>				
			</div>
		</div>
		<div id = "contentArea">
		
		<jsp:include page="${show }"></jsp:include>
		</div>
	</div>
</body>
</html>