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
 	function getProduct(page){
 		// json만 가능한 ajax줄임 버전 
 		$.getJSON("product.json?page="+page, function(productData){
 			$.each(productData.product, function(i, p) {
				var ntd = $("<td></td>").text(p.m_name);
				var ptd =  $("<td></td>").text(p.m_price);
				var tr = $("<tr></tr>").append(ntd,ptd);
				$("table").append(tr);
			});
 			
 		});
 		
 	}
 	
 	$(function() {
/*  		$.ajax({
 			url : "product.json",
 			success : function(productData){
 				alert(JSON.stringify(productData));
 			}
 		}); */
 		
		var page =1;
 		getProduct(page);
 		//바닥까지 스크롤 시 다음 페이지 보여 주기
 		$(window).scroll(function(){
 			var htmlH = $(document).height();//1500
 			var browserH = $(window).height();//390
 			var browserTop = $(window).scrollTop();//1510
 			var browserBottom = browserTop+browserH;//1900
 			if(browserBottom == htmlH){
 				page++;
 				getProduct(page);
 			}
 		});
 		
 		
	});
 	
 </script>
 <style type="text/css">
 	td{
 		height: 500px;
 	}
 </style>
</head>
<body>
	<table border="1">
	
	</table>

</body>
</html>