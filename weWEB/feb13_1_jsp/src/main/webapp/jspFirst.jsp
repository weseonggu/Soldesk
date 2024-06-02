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
<!-- 
JSP (java servlet page): html로 작성한걸 tomcat이 servlet으로 바꿔서 실행함 
 -->
 
 	<%!
 		public int getNo(){
 			Random r = new Random();
 			return r.nextInt();
 		}
 	%>
 	<%
 	
 	int x = getNo();
 	
 	%>
	<table border ="1" width ="300px" height = "300px">
		<tr>
			<td>
				<%
					if(x%2==0){
				%>
				<marquee><%= x %></marquee>
				<%
					}else{
				%>
				<h1><%= x %></h1>
				<%
					}
				%>
			</td> 
		</tr>
		
	</table>
</body>
</html>