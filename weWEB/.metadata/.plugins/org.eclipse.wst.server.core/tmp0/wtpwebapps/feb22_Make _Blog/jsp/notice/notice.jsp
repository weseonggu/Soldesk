<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/noticeStyle.css">
<script type="text/javascript">
function goDetail(no){
	location.href="NoticeDetailController?n="+no;
}
</script>
</head>
<body>
	<table id="noticeBBSArea">
		<tr>
			<td align="right"><a href="NoticeWriteController">글쓰기</a></td>
		</tr>
		<tr>
			<td align="center">
				<table  id = "showTXT">
					<tr>
						<th>제목</th>
						<th>날짜</th>					
						<th>작성자</th>					
					</tr>
					<c:forEach var = "n" items ="${notices }">
						<tr id = "txt" onclick="goDetail(${n.no});">
							<td>${n.title }</td>
							<td>
								<fmt:formatDate value="${n.date }" type="date" dateStyle="short"/>
							</td>
							<td>
							${n.writer }
							</td>
						</tr>
					</c:forEach>
				</table>
			
			</td>
		</tr>
		<tr>
			<td align="center">
			<c:forEach var ="p" begin="1" end="${pageCount }">
				<a href ="NoticeComtroller?p=${p }">${p }</a>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td align="center">
				<form action="NoticeSearchController">
					<input name = "search">
					<button>검색</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>