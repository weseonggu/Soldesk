<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>결과</h1>
<fmt:formatNumber value="${result.num }" pattern="#0.0"/>
${result.from } -> 
<fmt:formatNumber value="${result.result }" pattern="#0.0"/>
${result.to }
</body>
</html>