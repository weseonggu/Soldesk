<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.6.4.js"
  integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
  crossorigin="anonymous"></script>
 <script type="text/javascript">
 	function getMenu(){
 		$.ajax({
			url:"menu.get",
			success : function(menuData){
				$("table").empty();
				$(menuData).find("menu").each(function(i){
					var name =  $(this).find("m_name").text();
					var price = $(this).find("m_price").text();
					var ntd = $("<td></td>").text(name);
					var ptd =  $("<td></td>").text(price);
					var tr = $("<tr></tr>").append(ntd,ptd);
					$("table").append(tr);
				});
			}
		});
 	}
 	
 	
 	$(function() {
 		getMenu();
 		
		$("#b1").click(function(){
			var n = $("#name").val();
			var p =$("#price").val();
			$.ajax({
				url : "menu.reg",
				data : {m_name : n,m_price : p},// 파라메터 넣고 싶으면 이런식으로 작성
				success : function(menuResult){
					alert($(menuResult).text());
					getMenu();
				}
			});
			$("#name").val("");
			$("#price").val("");
		});
		$("#price").keyup(function(e) {
			if(e.keyCode == 13){
				//이벤트 강제 발생 - trigger("이벤트명")
				$("#b1").trigger("click");
			}
		});
		
		
		//검색
 		$("#search").keyup(function(e){
			//if(e.keyCode ==13){
				var sn = $("#search").val();
				$.ajax({
					url : "menu.search",
					data : {m_name : sn},
					success : function(menuData){
						$("table").empty();
						$(menuData).find("menu").each(function(i){
							var name =  $(this).find("m_name").text();
							var price = $(this).find("m_price").text();
							var ntd = $("<td></td>").text(name);
							var ptd =  $("<td></td>").text(price);
							var tr = $("<tr></tr>").append(ntd,ptd);
							$("table").append(tr);
						});
					}
				});
			//}
		});
		
		
		
		
		
	});
 	
 </script>
</head>
<body>
	이름: <input id ="name"><br>
	가격: <input id ="price"><br>
	<button id = "b1">등록</button>
	<hr>
	<input id ="search"><br>
	<hr>
	<table border="1">
	
	</table>
</body>
</html>