<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	//�ڵ��̵� second ->third �ڵ� �̵�
	int a = Integer.parseInt(request.getParameter("a"));
	int b = Integer.parseInt(request.getParameter("b"));
	int c =a+b;
	//�ڵ��̵� second ->third �ڵ� �̵�
	//		second�� �Ⱥ��̰� third�� �̵�
	// 1. redirect
	//		response.sendRedirect("third.jsp");
	// 2. forward
 	RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
	// 3. �ڹٿ��� ���� �����͵� third�� �ѱ�� ���
	request.setAttribute("c", c);// �⺻���� �ڵ����� ����ȯ �� 
	request.setAttribute("v", 234);
	Random r =new Random();
	request.setAttribute("r", r);
	//rd.forward(request, response);
	// 4. include (��ġ ���� �Ұ���)
	rd.include(request, response);
	%>

	<h1>second</h1>
	<%=a%>
	<%=b%>
</body>
</html>