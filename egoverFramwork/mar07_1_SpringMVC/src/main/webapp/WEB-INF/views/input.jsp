<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="resources/css/inputStyle.css">
<script type="text/javascript" src="resources/js/check.js"></script>
<script type="text/javascript" src="resources/js/weValidCheck.js"></script>
</head>
<body>
	<form name = "f" action="conversion.do" onsubmit="return check();">
		숫자: <input name ="n"><br>
		<button>변환</button>
	</form>
</body>
</html>