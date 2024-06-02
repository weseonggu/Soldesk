<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/indexStyle.css">
<script type="text/javascript" src="resources/js/weValidCheck.js"></script>
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
<script type="text/javascript" src="resources/js/WebSite_jQuery.js"></script>
<script type="text/javascript">
	<c:choose>
	<c:when test="${result == null }">
	</c:when>
	<c:otherwise>
		alert('${result}');
	</c:otherwise>
	</c:choose>
</script>
</head>
<body id="indexBody">
	<div id="backImg">
		<img alt="" src="resources/img/car.jpg">
	</div>
	<div id=titleBox>
		<div id="menu">
			<jsp:include page="${login }"></jsp:include>
		</div>
		<div id="title">
			<a href="index.do"><h1>SpringMVC + Mybatis WEB</h1></a>
		</div>
	</div>
	<div id=contents>
		<jsp:include page="${contents }"></jsp:include>
	</div>
</body>
</html>