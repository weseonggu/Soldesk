<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%
//1. V���� ������� (parameter)
//	 M���� �۾��Ѱ� (attribute)
//   �� �б� ���� EL
//2. ���ǹ�, �ݺ���
//3. ������� ����
//   2, 3���� Ŀ���� �±׷� �ذᰡ��
//   jsp�� ��������� �±� �������� ���� �ؼ� ���


// CostomTag
// ���α׷��� ���ɵ餷�� DOM��ü ���·�
// jsp�� �������� �ٲ� �ڹټҽ��� �ٲ�
// jsp���� ��
// <���ξ�:xxx>
// ��ǰ - JSPǥ�ؾ׼� �±� (�⺻������ ��밡��)
//		���ξ� = jsp
//request.getRequestDispatcher("test2.jsp").forward(request, response);
// -> <jsp:forward page="test2.jsp"></jsp:forward>
//response.sendRedirect(location;) - ����
//request.getRequestDispatcher("test2.jsp").include(request, response); - ��ġ ���� x
// -> <jsp:include page="test2.jsp"></jsp:include> - ��ġ ���� ���� �ҽ��� �����ͼ�  ���� �ڸ��� ����
// v -> �� ���x


// ����ǰ - ��Ÿ Ŀ���� �ױ�(Ÿ���� jar����)

%>
</head>
<body>
<h1>test</h1>

<jsp:include page="test2.jsp"></jsp:include>
</body>
</html>