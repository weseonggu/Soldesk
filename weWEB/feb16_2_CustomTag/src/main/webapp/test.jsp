<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%
//1. V에서 만들어진 (parameter)
//	 M에서 작업한거 (attribute)
//   를 읽기 위한 EL
//2. 조건문, 반복문
//3. 출력형식 지정
//   2, 3번은 커스텀 태그로 해결가능
//   jsp의 보기어려운걸 태그 형식으로 변경 해서 사용


// CostomTag
// 프로그램쪽 지능들ㅇ르 DOM객체 형태로
// jsp가 서블릿으로 바뀔때 자바소스로 바뀜
// jsp에서 만
// <접두어:xxx>
// 정품 - JSP표준액션 태그 (기본적으로 사용가능)
//		접두어 = jsp
//request.getRequestDispatcher("test2.jsp").forward(request, response);
// -> <jsp:forward page="test2.jsp"></jsp:forward>
//response.sendRedirect(location;) - 없음
//request.getRequestDispatcher("test2.jsp").include(request, response); - 위치 조절 x
// -> <jsp:include page="test2.jsp"></jsp:include> - 위치 조절 가능 소스를 가져와서  적은 자리에 넣음
// v -> 위 사용x


// 사제품 - 기타 커스텀 테그(타인의 jar파일)

%>
</head>
<body>
<h1>test</h1>

<jsp:include page="test2.jsp"></jsp:include>
</body>
</html>