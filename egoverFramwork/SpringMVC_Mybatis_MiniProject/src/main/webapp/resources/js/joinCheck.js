function joinCheck() {
	var name=document.joinForm.bm_name;
	var id=document.joinForm.bm_id;
	var pw=document.joinForm.bm_pw;
	var photo=document.joinForm.bm_photo;
	if(isEmpty(name)){
		alert("name");
		return false;
	}
	if(isEmpty(id)||$("#joinID").css("color")=="rgb(255, 255, 0)"){
		alert("id");
		return false;
	}
	if(isEmpty(pw)){
		alert("pw");
		return false;
	}
	if(isEmpty(photo)||(isNotType(photo,"jpg") && isNotType(photo,"png"))){
		alert("photo");
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

