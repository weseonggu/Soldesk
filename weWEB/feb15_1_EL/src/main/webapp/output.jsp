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
// �� �������� - EL
// for, if - Ŀ���� �±�
// ����������� - Ŀ���� �±�

// EL(Expression Language)
// ��(Parameter, Attribute) ������ ���
// ����
// ${???}
// ${param.�Ķ���͸�}
// ${��Ʈ����Ʈ��}
// ${��Ʈ����Ʈ.�ɹ�������} ��Ʈ����Ʈ�� ��ü�� ��
// Ŭ������ getter����� ���� �ڹ��ڵ�� ����Ǹ� getter�� ���; ����� 
// ����� tomcat���� �ڵ����� �ڹ� �ҽ��� ������
// ���� �Ķ���͸� ��� ���� �߻����� ������
// ������ ��밡�� ����ȯ �ڵ�
// for ���� EL�δ� �Ұ���
Person p =(Person)request.getAttribute("pp");
String b =request.getParameter("bir");
int a =(Integer)request.getAttribute("a");// �ѹ� ó���ϰ� �� �Ķ���ʹ� ������ attribute�� �ޱ�
ArrayList<Person> arr = (ArrayList<Person>)request.getAttribute("people");
%>
</head>
<body>
<%=p.getName() %><br>
<%=p.getAge() %>��
<h1>����: <%=b %></h1>
<hr>
<h1>����: ${param.bir }</h1>
${param.bir+10 }<br>
a:${a }<br>
�̸�: ${pp.name }<br>
�̸�: <%= arr.get(0).getName() %><br>
�̸�: ${people[0].name}<br>

</body>
</html>