function testCheck(){
	var f = document.inputForm.n;
	if (isEmpty(f)){
		alert("입력하시오");
		return false;
	}
	return true;
}

function addCheck(){
	var f =document.addInput.num;
	if(isEmpty(f)){
		alert("입력하시오");
		f.value="";
		f.focus();
		return false;
	}
	return true;
}