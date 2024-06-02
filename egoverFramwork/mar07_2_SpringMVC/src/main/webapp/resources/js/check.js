function check(){
	var input = document.f.num;
	if(isEmpty(input)||notContains(input, "1234567890")){
		alert("수를 입력하시오");
		input.value ="";
		input.focus();
		return false;
	}
	return true;
}