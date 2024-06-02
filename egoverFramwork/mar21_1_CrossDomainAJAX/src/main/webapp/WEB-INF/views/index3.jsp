<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

<script type="text/javascript">
	$(function() {
		//http://openAPI.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/5/
		var pm10 =[];
		var pm25 =[];
		$.ajax({
			url :"http://openAPI.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/25/",
			success : function(data){
				$(data).find("row").each(function(i){
					var pm10d = $(this).find("PM10").text()*1;
					var pm25d = $(this).find("PM25").text()*1;
					var loc = $(this).find("MSRSTE_NM").text();
					pm10[i] = {label : loc, y : pm10d};
					pm25[i] = {label : loc, y : pm25d};
				});
				var chart = new CanvasJS.Chart("chartContainer", {
					animationEnabled: true,
					title:{
						text: "미세먼지"
					},
					toolTip: {
						shared: true
					},
					legend: {
						reversed: true,
						verticalAlign: "center",
						horizontalAlign: "right"
					},
					data: [{
						type: "stackedColumn",
						name: "pm10",
						showInLegend: true,
						dataPoints: pm10
					}, 
					{
						type: "stackedColumn",
						name: "pm25",
						showInLegend: true,
						dataPoints: pm25
					}]
				});
				chart.render();
			}
			
		});

		
		
	
	
	
	
	
	
	
	
	
	});
</script>


</head>
<body>
	<div id="chartContainer" style="height: 300px; width: 100%;"></div>
</body>
</html>