function showSnsPopup(bs_no, bs_txt){
	
	bs_txt=bs_txt.replace(/<br>/g,"\r\n");// 정규식
	$("#popupArea").find("#bs_no").val(bs_no);
	$("#popupArea").find("textarea").val(bs_txt);
	$("#popupArea").css("top","0px");
	$("#popupArea").css("left","0px");
	$("#popupArea").css("opacity","1");
}