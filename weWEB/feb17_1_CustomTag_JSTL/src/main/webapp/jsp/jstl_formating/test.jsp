<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%
// JSTL-formating 출력 형식
// 소수점, 날짜요일

%>
</head>
<body>
${aaa } 숫자','찍기
<hr>
<fmt:formatNumber value ="${aaa }" type="number"/>
<hr>
<fmt:formatNumber value ="${aaa }" type="currency"
currencySymbol="$"/>
<fmt:formatNumber value ="${aaa }" type="currency"
currencySymbol="\\"/>
<hr>
${bbb }
<hr>
<fmt:formatNumber value ="${bbb }" type="percent"/>
<hr>
<fmt:formatNumber value ="${bbb }" pattern="#.00"/>
<hr>
<fmt:formatNumber value ="${ccc }" pattern="00000.000"/>
<hr>
<fmt:formatDate value="${eee }" type = "date" dateStyle="long"/>
<hr>
<fmt:formatDate value="${eee }" type = "time" timeStyle="short"/>
<hr>
<fmt:formatDate value="${eee }" type = "both" dateStyle="short" timeStyle="long"/>
<hr>
<fmt:formatDate value="${eee }" pattern="MM dd E "/>

</body>
</html>