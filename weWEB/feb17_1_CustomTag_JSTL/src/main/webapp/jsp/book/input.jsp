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
<button>�˻�</button>
</form>
<hr>
<div id="bookcontainer">
	<c:forEach var="arr" items ="${bookinfos }">
		<div id="bookInfo">
			<div id ="sumnail">
			<img alt="" src="${arr.img }">
			</div>
			<div >
				<p>����: ${arr.title }</p>
				<p>���ǻ�: ${arr.publisher }</p>
				<c:forEach var="author" items ="${arr.authors }">
				<p>����: ${author }</p>
				</c:forEach>
				<p>����: <fmt:formatNumber value ="${arr.price }" type="number"/>��</p>
				<a href="${arr.addr }" target="_blank">�����Ϸ� ����</a>
			</div>
		</div>
	</c:forEach>
</div>
</body>
</html>