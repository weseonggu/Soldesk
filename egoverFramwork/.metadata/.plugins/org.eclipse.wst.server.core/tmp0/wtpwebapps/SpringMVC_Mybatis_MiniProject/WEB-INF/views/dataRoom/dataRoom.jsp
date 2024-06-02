<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/dataRoom.css">
<script type="text/javascript" src="resources/js/FileCheack.js"></script>
</head>
<body>
	<div id =showData>
		<c:forEach var="data" items="${datas }">
			<div>
			<%
				//<a> get방식 요청
				//		1) 클릭하면 다른 이벤트로 하려면
				//		2) 브라우저가 열줄 아면 열어버림
				//		3) 주소만 알면 요청이 되니 ->로그인이 무쓸모(보안성이 떨어짐)
			%>
				<%-- <a href = "resources/Data/${data.bd_file}" download>다운 받기</a> --%>
				<a href = "data.download?file=${data.bd_file}">다운 받기</a>
				<span>${data.bd_uploader }</span>
				<span>${data.bd_title }</span>
				<span><fmt:formatDate value="${data.bd_date }" type="date"/>  </span>
			</div>
		</c:forEach>
	</div>
	<div id="dataPage">
	<div>
		<c:forEach var="p" begin="1" end="${pages }">
			<a href="dataroom.go?p=${p }">${p }</a>
		</c:forEach>
	</div>
	</div>
	<div id="dataRoomInput" >
		<form action="dataroom.upload" method="post" name = "fileform"
		enctype="multipart/form-data" onsubmit="return fileCheck();">
			<input name ="token" value="${token }">
			<input name = "bd_title"><br>
		 	<input name = "bd_file" type="file"><br>
		 	<button>업로드</button>
		</form>
	</div>
</body>
</html>