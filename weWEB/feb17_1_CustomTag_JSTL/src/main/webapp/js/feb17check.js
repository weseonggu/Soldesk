function testCheck(){
	var f = document.inputForm.n;
	if (isEmpty(f)){
		alert("�Է��Ͻÿ�");
		return false;
	}
	return true;
}

function addCheck(){
	var f =document.addInput.num;
	if(isEmpty(f)){
		alert("�Է��Ͻÿ�");
		f.value="";
		f.focus();
		return false;
	}
	return true;
}