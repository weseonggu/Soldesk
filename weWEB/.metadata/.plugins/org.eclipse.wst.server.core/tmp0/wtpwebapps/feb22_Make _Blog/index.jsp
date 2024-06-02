<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" href="css/indexStyle.css">
<script type="text/javascript" src = "js/weValidCheck.js"></script>

<script type="text/javascript">
	<c:choose>
		<c:when test="${alert == null }">
		</c:when>
		<c:otherwise>
		alert('${alert}');
		</c:otherwise>
	</c:choose>

</script>
</head>
<body id = "indexBody">
	<div id="indexArea">
		<div id="siteTitle">
			<a href = "HomeController"><h1>MiniProject</h1></a>
			<c:choose>
				<c:when test="${login == null }">
				</c:when>
				<c:otherwise>
					<jsp:include page="${login }"></jsp:include>
				</c:otherwise>
			</c:choose>
		</div>
		<div id = "mainMenu">
			<div>
				<a href="NoticeComtroller">공지사항</a>			
			</div>
		</div>
		<div id = "contentArea">
		
		<jsp:include page="${show }"></jsp:include>
		</div>
	</div>
</body>
</html>