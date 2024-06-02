<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/joinStyle.css">
<script type="text/javascript" src = "js/weValidCheck.js"></script>
<script type="text/javascript" src = "js/joinCheck.js"></script>
<script type="text/javascript">
function showAlert(r){
	alert(r);
}
</script>
</head>
<c:choose>
	<c:when test="${exception == null }">
		<body>
	</c:when>
	<c:otherwise>
		<body onload="showAlert('${exception}');">
	</c:otherwise>
</c:choose>
<div id = "joinPage">
	<div>
		<div>
			<h1> 회원 가입</h1>
			<form action = "JoinController" method="post" enctype="multipart/form-data"
			onsubmit="return joinCheck();" name = "joinF">
				<input name = "id" maxlength="20" placeholder="아이디">
				<input name = "pw" maxlength="20" placeholder="비밀번호">
				<input name = "pwCheck" maxlength="20" placeholder="비밀번호 확인">
				<input name = "uName" maxlength="7" placeholder="사용자이름">
				<div id ="birthselect">
					생년<select name ="year">
						<c:forEach var="y" begin="${cy-120 }" end="${cy }">
							<option value=${y }>${y}
						</c:forEach>
					</select>
					월<select name ="month">
						<c:forEach var="m" begin="1" end="12">
							<option value=${m }>${m}
						</c:forEach>
					</select>
					일<select name ="day">
						<c:forEach var="d" begin="1" end="31">
							<option value=${d }>${d}
						</c:forEach>
					</select>
				</div>
				<input name ="photo" type="file" accept=".jpg,.png">
				<button>가입히기</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>