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
	//request - �����̵�(���� �׼��� ���ϸ� �̵�)
	// 1. <a> : get��Ŀ�û
	// 2. location.href = "second.jsp"; - javascript�� get��� ��û
	// 3. form���� ��ư: get/post��� ���ð���
	// 		�Է� ���� �ɷ� �ּҸ� ���� �ڵ����� ��û
%>
	<h1>first</h1>
	<a href="second.jsp?a=7&b=9">second��</a>
	<hr>
	<div onclick="go();" ><p>second��</p></div>
	<form action= "second.jsp">
		a: <input name="a"><br>
		b: <input name="b"><br>
		<button>go</button>
	</form>
</body>
</html>