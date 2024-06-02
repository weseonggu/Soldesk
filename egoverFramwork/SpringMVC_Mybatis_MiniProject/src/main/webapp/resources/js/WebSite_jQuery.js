function connectMenuSummonEvent(){
	$("#titleBox").mouseenter(function(){
		$("#menu").css("display","block");
	});
	$("#titleBox").mouseleave(function(){
		$("#menu").css("display","none");
	});
}

function snsPostwrite(){
	var is =true;
	$("#writeButton").click(function(){
		if(is == true){
			$("#writeForm").css("display","block");
		}else{
			$("#writeForm").css("display","none");
		}
		is = !is;
	});
}


function cancleRewrite(){
	$("#cancleRewrite").click(function(){
		$("#popupArea").css("opacity","0");
		setTimeout(function(){
			$("#popupArea").css("top","-100%");
			$("#popupArea").css("left","-100%");
		},300);
	})
}

$(function() {
	connectMenuSummonEvent();
	snsPostwrite();
	cancleRewrite();
})