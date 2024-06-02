<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id = "logoutForm">
		<img id="profile" alt="" src="img/${sessionScope.loginMember.photo }">
		<form action="LoginController" method="get" >
			<p>${sessionScope.loginMember.id }</p> 
			<p>${sessionScope.loginMember.name }</p> 
			<button>로그아웃</button>
			<a href ="MemberInfoController">회원정보</a>
		</form>
	</div>
</body>
</html>