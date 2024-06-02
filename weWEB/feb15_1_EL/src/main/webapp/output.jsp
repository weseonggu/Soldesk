<%@page import="java.util.ArrayList"%>
<%@page import="com.we.main.Person"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%
// 값 받으려면 - EL
// for, if - 커스텀 태그
// 출력형식지정 - 커스텀 태그

// EL(Expression Language)
// 값(Parameter, Attribute) 받을때 사용
// 문법
// ${???}
// ${param.파라메터명}
// ${어트리뷰트명}
// ${어트리뷰트.맴버변수명} 어트리뷰트가 객체일 때
// 클래스에 getter지우면 오류 자바코드로 변경되면 getter로 빠귀어서 실행됨 
// 실행시 tomcat에서 자동으로 자바 소스로 변경함
// 없는 파라메터를 적어도 예외 발생없이 실행함
// 연산자 사용가능 형변환 자동
// for 문은 EL로는 불가능
Person p =(Person)request.getAttribute("pp");
String b =request.getParameter("bir");
int a =(Integer)request.getAttribute("a");// 한번 처리하고 온 파라미터는 무조건 attribute로 받기
ArrayList<Person> arr = (ArrayList<Person>)request.getAttribute("people");
%>
</head>
<body>
<%=p.getName() %><br>
<%=p.getAge() %>살
<h1>생일: <%=b %></h1>
<hr>
<h1>생일: ${param.bir }</h1>
${param.bir+10 }<br>
a:${a }<br>
이름: ${pp.name }<br>
이름: <%= arr.get(0).getName() %><br>
이름: ${people[0].name}<br>

</body>
</html>