<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/infoStyle.css">
<script type="text/javascript" src = "js/info.js"></script>
<script type="text/javascript" src = "js/weValidCheck.js"></script>
</head>
<body >
	<div id = "infoPage">
	<div>
		<img alt="" src="img/${sessionScope.loginMember.photo }" id="qwer">
		<form action="MemberInfoController" method="post" enctype="multipart/form-data"
		onsubmit="return infoCheck();" name ="infoF">
			id : ${sessionScope.loginMember.id }<br>
			이름 : ${sessionScope.loginMember.name }<br>
			<input name="changPW" value= "${sessionScope.loginMember.pw }" ><br>
			<input name = "PWCheck1" placeholder="비번확인"><br>
			<input name = "changePhoto" type="file" accept=".png, .jpg"><br>
			<button>수정</button>
		</form>
		<button onclick="bye();">탈퇴</button>
	</div>
	</div>


</body>
</html>