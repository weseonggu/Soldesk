function loginCheck(){
	var loginid = document.loginForm.id;
	var loginpw = document.loginForm.pw;
	
	if(isEmpty(loginid) || isEmpty(loginpw)){
		alert("아이디, 비번을 입력하세요");
		loginid.value ="";
		loginpw.value ="";
		loginid.focus();
		return false;
	}
	return true;
}