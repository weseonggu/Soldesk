<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailStyle.css">
<script type="text/javascript" src="js/comment.js"></script>
</head>
<body>
<form action="NoticeModifyController">
	<div id ="detail">
		<img alt="" src="img/${ndata.photo }">
		<div id="detailinfo">
			<p> 글제목: <input name = "change title" value="${ndetail.title }"></p>
			<p> 글쓴이: ${ndata.name }</p>
			<p> 글쓴이 id: ${ndetail.writer }</p>
		</div>
	</div>
	<div id = "detailcontext">
		<textarea name="chageTXT" rows="10">${ndetail.txt }</textarea>
	</div>
	
	<table id="comment">
		<tr>
			<td align="center">
				<input id = "token" value="${token }" readonly="readonly" type= "hidden">
				<input id ="bn_no" value="${ndetail.no}" type= "hidden">
				댓글: <input id = "txt" class="replyInput">
				<span onclick="writeComment();">쓰기</span>
			</td>
		</tr>
		<c:forEach var="comt" items="${comments }">
			<tr id="userComment">
			<td align="left">
			<div>
			<span>${comt.bnr_writer }</span> 
			<span>${comt.bnr_txt }</span> 
			<span>${comt.bnr_date }</span>
			</div>
			</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	<c:choose>
		<c:when test="${sessionScope.loginMember.id == ndetail.writer }">
			<div id = "fixDelete">
				<button>수정</button>
				<a href="NoticeDeleteController?nno=${ndetail.no }">삭제</a>
			</div>
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
	</c:choose>
</form>


</body>
</html>