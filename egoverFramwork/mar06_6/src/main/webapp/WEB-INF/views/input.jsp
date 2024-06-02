<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "resources/js/weValidCheck.js"></script>
<script type="text/javascript" src = "resources/js/check.js"></script>
</head>
<body>
input
<form action= "point.calc" onsubmit="return check();" name = "f" method="post">
	name: <input name = "name"><br>
	price: <input name = "price"><br>
	<button>적립</button>
</form>
</body>
</html>