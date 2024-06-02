<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aa8ed2785db0138dc7d9bdb1f5756790"></script>
	<script>
	
			var lat;
			var lng;
			var map =null;
			var roadview= null;
			var roadviewClien=null;
			var myloc =null;
			var marker=null;
		$(function(){

			
			
			
			//html5dp클라이언트 위치를 받는 기능이 추가 됨
			//	gps있는  기계로 사이트에 접속 :gps로
			// gps없는 기계로 접속:
			navigator.geolocation.getCurrentPosition(function(loc){
				lat = loc.coords.latitude;//위도
				lng = loc.coords.longitude;//경도
				
				myloc = new kakao.maps.LatLng(lat, lng);
				var container = document.getElementById('map');
				var options = {
					center: myloc,
					level: 3
				};
				
				map = new kakao.maps.Map(container, options);
				
				marker = new kakao.maps.Marker({
				    map: map,
				    position: myloc
				});
				
				
				var roadviewContainer = document.getElementById("roadview"); //로드뷰를 표시할 div
				roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
				roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체


				// 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
				roadviewClient.getNearestPanoId(myloc, 50, function(panoId) {
				    roadview.setPanoId(panoId, myloc); //panoId와 중심좌표를 통해 로드뷰 실행
				});
			});
			
			
			$("input").keyup(function(e) {
				var location = [];
				var container = document.getElementById('map2');
				if(e.keyCode == 13){
					var search = $(this).val();// 인코딩 필요한경우 encodeURIComponent(인코딩 할 변수);
					$.ajax({
						url:"https://dapi.kakao.com/v2/local/search/keyword.json",
						data:{y:lat, x:lng, radius:3000, query : search,  sort:"distance"},
						beforeSend: function (xhr) {
				            xhr.setRequestHeader("Authorization", "KakaoAK 8dc0783d71d5cb4ec931041f4733fe64");
				        },
				        success: function(data){
				        	$("table").empty();
				        	$.each(data.documents,function(i,loc){
				        		var ytd = $("<td></td>").text(loc.y);
				        		var xtd = $("<td></td>").text(loc.x);
				        		var ntd = $("<td></td>").text(loc.place_name);
				        		var dtd = $("<td></td>").text(loc.distance);
				        		var tr = $("<tr></tr>").attr("onclick","moveMap("+loc.y+","+loc.x+");").append(ytd,xtd,ntd,dtd);
				        		$("table").append(tr);
				        		location[i] = {y: loc.y,x: loc.x };
				        	});
				        	
				        	
				        }
					});
				}
			});
	
		});
		function moveMap(y,x){
			myloc = new kakao.maps.LatLng(y, x);
			roadviewClient.getNearestPanoId(myloc, 50, function(panoId) {
			    roadview.setPanoId(panoId, myloc); //panoId와 중심좌표를 통해 로드뷰 실행
			});

			var container = document.getElementById('map');
			var options = {
				center: new kakao.maps.LatLng(y, x),
				level: 3
			};
			
			map = new kakao.maps.Map(container, options);
			var marker = new kakao.maps.Marker({
			    map: map,
			    position: new kakao.maps.LatLng(y, x)
			});
			var clusterer = new kakao.maps.MarkerClusterer({
			    map: map,
			    markers: marker,
			    gridSize: 35,
			    averageCenter: true,
			    minLevel: 6,
			    disableClickZoom: true,
			    styles: [{
			        width : '53px', height : '52px',
			        background: 'url(cluster.png) no-repeat',
			        color: '#fff',
			        textAlign: 'center',
			        lineHeight: '54px'
			    }]
			});
			clusterer.addMarker( marker );
		}
	</script>





</head>
<body>
	<div id="map" style="width:500px;height:400px;"></div>
	<div id="roadview" style="width:500px;height:400px;"></div>
	<input>
	<!-- <div id="map2" style="width:500px;height:400px;"></div> -->
	<table border="1">
	</table>
</body>
</html>