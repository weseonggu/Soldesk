<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/snsStyle.css">
<script type="text/javascript" src="resources/js/sns.js"></script>
<script type="text/javascript">
function search() {
	var search = document.getElementById("search");
	location.href = "sns.go?search="+search.value;
}

</script>
</head>
<body>
	<div id ="popupArea">
		<form action="" id ="rewriteForm">
			<input name ="token" value = ${token } type="hidden">
			<input name="" type="hidden" id="bs_no">
			<textarea name ="bs_txt"></textarea><br>
			<button>쓰기</button>
		</form>
		<button id= "cancleRewrite">쓰기 취소</button>
	</div>
	<div id = "post">
			<c:forEach var="post" items="${posts }">
				<div id= "textbox">
					<img alt="" src="resources/img/${post.bm_photo }">
					<div id = "text">
						<span>${post.bs_writer }</span>
						<span id = "postDate">${post.bs_date }</span><br>
						<span>${post.bs_txt }</span>
						<c:if test="${post.bs_writer == sessionScope.loginMember.bm_id }">
							<a href="sns.delete?delete=${post.bs_no }">삭제</a>
							<button class="popupButton" onclick=" showSnsPopup(${post.bs_no}, '${post.bs_txt}');">수정</button><br>
						</c:if>
					</div>
				</div>
					<div id ="comment">
						<form action="sns.comment">
							<input name ="commentToken" value = ${token } type="hidden">
							<input name ="bsc_bs_no" value = ${post.bs_no } type="hidden">
							<c:forEach var = "cs" items="${comments }">
 								<c:choose>
								<c:when test="${post.bs_no == cs.bsc_bs_no }">
									${cs.bsc_writer } 댓글: ${cs.bsc_txt }<br>
									<fmt:formatDate value="${cs.bsc_date}" type="date"/><br>
									<hr>
								</c:when>
								<c:otherwise>
								</c:otherwise>
								</c:choose> 
							</c:forEach>
								
							<input name = "bsc_writer" value="${sessionScope.loginMember.bm_id}" type="hidden">
							<input name ="bsc_txt">
							<button>쓰기</button>
						</form>
					</div>
			</c:forEach>
			<div id="page">
				<input name="search" id="search"><button onclick="search();">검색</button><br>
				<c:forEach var="p" begin="1" end="${page }">
					<span><a href="sns.go?page=${p }&search=${sessionScope.search}">${p }</a></span>
				</c:forEach>
			</div>
	</div>
	<div id ="writeArea">
		<button id = "writeButton">글쓰기</button>
		<form action="sns.post.write" id ="writeForm">
			<input name ="token" value = ${token } type="hidden">
			<textarea name ="bs_txt"></textarea>
			<button>쓰기</button>
		</form>
	</div>
</body>
</html>