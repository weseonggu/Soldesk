<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel = "stylesheet" href="css/writeStyle.css">
<script type="text/javascript" src = "js/wite.js"></script>
</head>
<body>
	<form action="NoticeWriteController" onsubmit="return writeCheck()" name = writeF
	method="get">
		<input name = token value="${token }" readonly="readonly" type ="hidden">
		<table id ="write">
			<tr>
				<td align="center">
					<input name="title" placeholder="제목">
				</td>
			</tr>
			<tr>
				<td align="center">
					<textarea name ="txt" placeholder="내용"></textarea>
				</td>
			</tr>
			<tr>
			<td align="center">
				<button>쓰기</button>
			</td>
			</tr>
		</table>
	</form>
</body>
</html>