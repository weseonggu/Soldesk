<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bookStyle.css">
</head>
<body>
<form action="">
<input name= "search">
<button>검색</button>
</form>
<hr>
<div id="bookcontainer">
	<c:forEach var="arr" items ="${bookinfos }">
		<div id="bookInfo">
			<div id ="sumnail">
			<img alt="" src="${arr.img }">
			</div>
			<div >
				<p>제목: ${arr.title }</p>
				<p>출판사: ${arr.publisher }</p>
				<c:forEach var="author" items ="${arr.authors }">
				<p>저자: ${author }</p>
				</c:forEach>
				<p>가격: <fmt:formatNumber value ="${arr.price }" type="number"/>원</p>
				<a href="${arr.addr }" target="_blank">구매하러 가기</a>
			</div>
		</div>
	</c:forEach>
</div>
</body>
</html>