<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/check.js"></script>
<script type="text/javascript" src="resources/js/weValidCheck.js"></script>
</head>
<body>
	<form action="convert.do" name ="f" onsubmit="return check();">
		변환 값<br>
		<input name = "num"><br>
		변환 단위<br>
		<input type="radio" name = "danwi" value ="inch" checked="checked">cm -> inch<br>
		<input type="radio" name = "danwi" value ="㎡">평 -> ㎡<br>
		<button>변환</button>
	</form>
</body>
</html>