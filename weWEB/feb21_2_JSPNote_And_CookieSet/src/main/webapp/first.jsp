<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function goSecond(){
		
		location.href = "SecondController";
	}
</script>
</head>
<body>
<h1>first</h1>
<a href="SecondController">second.jsp로</a>
<h2 onclick="goSecond();">second.jsp로</h2>
<form action = "SecondController" method="get">
	<input name = "n">
	<button>go</button>
</form>
</body>
</html>