<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
//JSTL(JSP Standard Tag Library)
//<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
//jstl�� ���� ������ attribute �����
%>
<body>

	<h1>${xxx }</h1>
	<c:if test="${xxx%2 ==0 }">
		<h2>¦����</h2>
	</c:if>
	<hr>
	<!-- if-else -->
	<c:choose>
		<c:when test="${xxx>6 }">
			<h2>6����Ŀ</h2>
		</c:when>
		<c:when test="${xxx>2 }">
			<h2>2����Ŀ</h2>
		</c:when>
		<c:otherwise>
			<h2>�����۾�</h2>
		</c:otherwise>
	</c:choose>
	<hr>
	<!-- for�� -->
	<c:forEach var="i" begin="1" end="5">
	<h1>z</h1>
	</c:forEach>
	<!-- for-each�� -->
	<c:forEach var="s" items="${ar }">
		<h1>${s }</h1>
	</c:forEach>
	<!-- for�� ���� ����x-->
	<c:forEach var="i" begin="1" end="5" step="2">
		<h1>as</h1>
	</c:forEach>
	<hr>
	
	<h2>${ps[0].name } - ${ps[0].price }</h2>
	
	<hr>
	
	<c:forEach var="p" items="${ps }">
		<p>${p.name } - ${p.price }</p>
	</c:forEach>
</body>
</html>