function writeComment(){
	var noFeild =document.getElementById("bn_no");
	var txtFeild =document.getElementById("txt");
	var token =document.getElementById("token");
	if(!isEmpty(txtFeild)){
		location.href = "CommentController?n="+noFeild.value
		+"&txt="+txtFeild.value+"&token="+token.value;
	}
}