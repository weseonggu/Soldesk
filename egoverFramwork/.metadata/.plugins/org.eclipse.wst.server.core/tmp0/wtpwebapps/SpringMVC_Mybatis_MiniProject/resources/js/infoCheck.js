function bye(){
	if(confirm("탈퇴하나요?")){
		location.href = "click.info.bye";
	}else{
		location.href = "click.info";
	}
}
function changeCheck(){
	var pw = document.mForm.bm_pw;
	var c_pw = document.mForm.pwcheck;
	var  addr1= document.mForm.addr1;
	var  addr2= document.mForm.addr2;
	var  addr3= document.mForm.addr3;
	
	
	if(!isEmpty(pw)){
		if(pw.value != c_pw.value){
			alert ("비번 확인");
			return false;
		}	
	}
	if(isEmpty(addr1)||isEmpty(addr2)||isEmpty(addr3)){
		alert ("주소 입력 하시오");
		return false;
	}
	
	return true;
}
$(function(){
	$("#joinAddr1").click(function(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	        	$("#joinAddr1").val(data.zonecode);
	        	$("#joinAddr2").val(data.address);
	        }
	    }).open();
	});
	$("#joinAddr2").click(function(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	        	$("#joinAddr1").val(data.zonecode);
	        	$("#joinAddr2").val(data.address);
	        }
	    }).open();
	});
})