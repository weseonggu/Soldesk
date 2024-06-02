function check(){
	var data = document.t.data;
	if(isEmpty(data) || insNotNumber(data)){
		alert("숫자를 입력하시오");
		data.value="";
		data.focus();
		return false;
	}
	return true;
}