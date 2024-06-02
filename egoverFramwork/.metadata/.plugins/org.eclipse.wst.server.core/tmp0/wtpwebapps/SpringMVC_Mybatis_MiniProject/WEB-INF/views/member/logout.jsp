<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/logoutStyle.css">
<script type="text/javascript">
	function logout() {
		location.href = "click.logout";
	}
	function info() {
		location.href = "click.info";
	}
</script>
</head>
<body>
	<table id="menuTable">
		<tr>
		<td>
			<a href="sns.go"><img alt="" src="resources/img/menu.png"></a>
		</td>
		<td>
			<a href="dataroom.go"><img alt="" src="resources/img/search.png"></a>
		</td>
		</tr>
	
	</table>

	<table id="logoutPage">
		<tr>
			<td><img alt=""
				src="resources/img/${sessionScope.loginMember.bm_photo }">
			</td>
			<td>
				<p>${sessionScope.loginMember.bm_name }</p>
				<button onclick="logout();">로그아웃</button>
				<button onclick="info();">회원정보</button>
			</td>
		</tr>
	</table>
</body>
</html>