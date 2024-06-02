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
			<a href = "HomeController"><h1>FEB17~20(��~��)</h1></a>
		</div>
		<div id = "mainMenu">
			<div>
				<a href="TestController">����</a>
				<a href="AddController">�� ���ϱ�</a>
				<a href="LottoController">�ζ�</a>
				<a href="JSTLController">JSTL</a>
				<a href="WeatherController">����</a>				
				<a href="JSTLFormatingController">JSTL-formating</a>				
				<a href="BookController">å �˻�</a>				
			</div>
		</div>
		<div id = "contentArea">
		
		<jsp:include page="${show }"></jsp:include>
		</div>
	</div>
</body>
</html>