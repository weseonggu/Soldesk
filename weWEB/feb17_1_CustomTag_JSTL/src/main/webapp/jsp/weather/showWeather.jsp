<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="euc-kr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="euc-kr">
<title>Insert title here</title>

</head>
<body>
<h1>����</h1>
<div id ="weatherCon">
<c:forEach var="data" items="${weatherData}">
<div id= "weatherInfo">
	<img alt="" src="img/weather/${data.engWeather}.png">
	<span>${data.time }�� ����</span>
	<span>${data.doo }��</span>
	<span>����: ${data.weather}</span>
</div>

</c:forEach>
</div>
</body>
</html>