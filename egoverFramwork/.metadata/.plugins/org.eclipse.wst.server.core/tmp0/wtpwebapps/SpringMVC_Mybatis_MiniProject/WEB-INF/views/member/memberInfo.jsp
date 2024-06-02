<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/infoStyle.css">
<script type="text/javascript" src="resources/js/infoCheck.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div id="infoPage">
		<div>
			<form name = "mForm" action="member.info.change" method="post" 
			onsubmit="return changeCheck();"
			enctype="multipart/form-data">
				<h1>회원 정보</h1>
				<img alt=""
					src="resources/img/${sessionScope.loginMember.bm_photo }">
				이름:<br> <input name="bm_name"
					value="${sessionScope.loginMember.bm_name }" readonly="readonly"><br>
				id:<br> <input name="bm_id" value="${sessionScope.loginMember.bm_id }"
					readonly="readonly"><br> 
				pw:<br> <input name="bm_pw"
					value="${sessionScope.loginMember.bm_pw }"><br> 
				pw확인:<br><input name= "pwcheck"><br>
				주소:<br>
				<input id ="joinAddr1"name="addr1" value="${addr1 }" readonly="readonly"><br> 
				<input id ="joinAddr2" name="addr2" value="${addr2 }" readonly="readonly"><br> 
				<input name="addr3" value="${addr3}"><br> 
				<input name="bm_photo" type="file"><br>
				<button>수정</button>
			</form>
			<button onclick="bye();">탈퇴</button>
		</div>
	</div>
</body>
</html>