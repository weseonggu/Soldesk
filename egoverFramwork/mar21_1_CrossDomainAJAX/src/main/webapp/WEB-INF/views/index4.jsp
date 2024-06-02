<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script type="text/javascript">
//	jskey: aa8ed2785db0138dc7d9bdb1f5756790
//  rest: 8dc0783d71d5cb4ec931041f4733fe64
	$(function() {
		
		
		//$.getJSON은 헤더 처리가 불가능 하다 그래서 $.ajax사용해야함
			var s =$(".slider").bxSlider();
			$("input").keyup(function(e){
				//if(e.keyCode ==13){
					var search = $("input").val();
					$.ajax({
						url:"https://dapi.kakao.com/v2/search/image",
						data : {query: search},
						beforeSend: function (xhr) {
				            xhr.setRequestHeader("Authorization", "KakaoAK 8dc0783d71d5cb4ec931041f4733fe64");
				        },
						success : function(data){
							$(".slider").empty();
							$.each(data.documents, function(i, d) {
								var div =$("<div></div>").html("<img src="+d.image_url+">");
 								var a=$("<p></p>").text(d.image_url);
								$("body").append(a);
								$(".slider").append(div);
							});
							s.reloadSlider();
						       
						}
					});
				//}
			});
		
		
		
			
		});

		
		
	
	
	
	
	
	
	
	
	
</script>
<style type="text/css">
	img{
		width: 100px;
		object-fit : contain;
	}
</style>


</head>
<body>
	<input>
	<hr>
	<div class="slider">
    </div>
</body>
</html>