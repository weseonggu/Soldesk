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
		뭐: <input name="www" autofocus><br> 전에 쓴 값:${param.www}<br>
		결과:${ans}<br>
		턴: ${tun}<br>
		<button>확인</button>
	</form>
</body>
</html>