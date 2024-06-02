<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	function go(){
		location.href = "second.jsp?a=7&b=9";
	}
</script>
</head>
<body>
<%
	//request - 수동이동(뭔가 액션을 취하면 이동)
	// 1. <a> : get방식요청
	// 2. location.href = "second.jsp"; - javascript로 get방식 요청
	// 3. form속의 버튼: get/post방식 선택가능
	// 		입력 받은 걸로 주소를 만들어서 자동으로 요청
%>
	<h1>first</h1>
	<a href="second.jsp?a=7&b=9">second로</a>
	<hr>
	<div onclick="go();" ><p>second로</p></div>
	<form action= "second.jsp">
		a: <input name="a"><br>
		b: <input name="b"><br>
		<button>go</button>
	</form>
</body>
</html>