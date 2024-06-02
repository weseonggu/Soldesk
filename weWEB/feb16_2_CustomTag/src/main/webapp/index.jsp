<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/indexStyle.css">
<link rel="stylesheet" href="css/calc.css">
<script type="text/javascript" src = "js/weValidCheck.js"></script>
<script type="text/javascript" src = "js/check.js"></script>
<!-- css, js, img의 경로설정 controller기준 지존과 동일 하게 쓰면 됨 -->
</head>
<body>
	<table>
		<tr>
			<td id = "siteTitle">
				<h1>사이트 제목</h1>
			</td>
		</tr>
		<tr>
			<td id = "menu">
				<a href="HomeController">홈</a>
				<a href="Menu1Controller">메뉴1</a>
				<a href="Menu2Controller">더셈</a>
				<a href="BaseballController">숫자야구</a>
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="${homea }"></jsp:include>
				
			</td>
		</tr>
	</table>
</body>
</html>