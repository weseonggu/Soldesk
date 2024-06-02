<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/joinStyle.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src = "resources/js/joinCheck.js"></script>
<script type="text/javascript">
	$(function(){
		$("#joinID").keyup(function(){
			var id = $(this).val();
			//alert(id);
			$.getJSON("member.id.check?bm_id="+id, function(data){
				if(data.members[0]==null){
					$("#joinID").css("color","black");
				}else{
					$("#joinID").css("color","yellow");
				}
			});
		});
	});

</script>
</head>
<body>
	<div id="joinPage">
		<h1>회원 가입</h1>
		<form  name = "joinForm" action="member.join.do" 
		method="POST" onsubmit="return joinCheck();" enctype="multipart/form-data">
			<input name ="bm_name" placeholder="이름"><br>
			<input name ="bm_id" placeholder="id" id ="joinID"><br>
			<input name ="bm_pw" placeholder="pw"><br>
			생년<select name="year">
				<c:forEach var="y" begin="${curYear -120 }" end = "${curYear }">
					<option value="${y }">${y }년</option>
				</c:forEach>
			</select>
			월<select name="month">
				<c:forEach var="m" begin="1" end = "12">
					<option value="${m }"> ${m }월</option>
				</c:forEach>			
			</select>
			일<select name="day">
				<c:forEach var="d" begin="1" end = "31">
					<option value="${d }"> ${d }일</option>
				</c:forEach>
			</select><br>
			주소:<br>
			<input id = "joinAddr1" name ="addr1" readonly="readonly" placeholder="우편번호"><br>
			<input id = "joinAddr2" name ="addr2" readonly="readonly" placeholder="주소"><br>
			<input name ="addr3" placeholder="상세주소"><br>
			프사: <input name="bm_photo" type="file"><br>
			<button>가입</button>			
		</form>
	</div>
</body>
</html>