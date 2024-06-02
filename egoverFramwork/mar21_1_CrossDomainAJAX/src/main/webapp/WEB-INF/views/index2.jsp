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
		var yd=[];
		$.ajax({
			url : "weather.get",
			data : {zone : 1135063000},
			success : function(data){
				$(data).find("data").each(function(i){
 					if($(this).find("day").text()=="1"){
						return false;
					}
 					var t= $(this).find("temp").text()*1;
					var htd = $("<td></td>").text($(this).find("hour").text());
					var ttd =  $("<td></td>").text($(this).find("temp").text());
					var ktd =  $("<td></td>").text($(this).find("wfKor").text());
					var tr = $("<tr></tr>").append(htd,ttd,ktd);
					$("table").append(tr);
					yd[i] ={label: $(this).find("hour").text(), y: t};
				});
				var chart = new CanvasJS.Chart("chartContainer", {
					title:{
						text: "기상청"              
					},
					data: [              
					{
						// Change type to "doughnut", "line", "splineArea", etc.
						type: "line",
						dataPoints: yd
					}
					]
				});
				chart.render();
			}
		});
	

		
		
	
	
	
	
	
	
	
	
	
	});
</script>


</head>
<body>

	<table border="1">

	
	</table>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
</body>
</html>