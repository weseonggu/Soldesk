<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="HomeController" method="get" name="fff">
		��: <input name="www" autofocus><br> ���� �� ��:${param.www}<br>
		���:${ans}<br>
		��: ${tun}<br>
		<button>Ȯ��</button>
	</form>
</body>
</html>