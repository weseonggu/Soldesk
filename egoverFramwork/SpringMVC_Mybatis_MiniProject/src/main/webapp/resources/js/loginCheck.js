function loginCheck(){
	var id = document.loginForm.bm_id;
	var pw = document.loginForm.bm_pw;
	if(isEmpty(id)){
		alert("id");
		id.focus();
		return false;
	}
	if(isEmpty(pw)){
		alert("pw");
		pw.focus();
		return false;
	}
	return true;
	
}