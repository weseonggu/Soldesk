function loginCheck(){
	var loginid = document.loginForm.id;
	var loginpw = document.loginForm.pw;
	
	if(isEmpty(loginid) || isEmpty(loginpw)){
		alert("���̵�, ����� �Է��ϼ���");
		loginid.value ="";
		loginpw.value ="";
		loginid.focus();
		return false;
	}
	return true;
}