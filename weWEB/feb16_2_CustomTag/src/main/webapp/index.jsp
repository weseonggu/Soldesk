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
<!-- css, js, img�� ��μ��� controller���� ������ ���� �ϰ� ���� �� -->
</head>
<body>
	<table>
		<tr>
			<td id = "siteTitle">
				<h1>����Ʈ ����</h1>
			</td>
		</tr>
		<tr>
			<td id = "menu">
				<a href="HomeController">Ȩ</a>
				<a href="Menu1Controller">�޴�1</a>
				<a href="Menu2Controller">����</a>
				<a href="BaseballController">���ھ߱�</a>
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