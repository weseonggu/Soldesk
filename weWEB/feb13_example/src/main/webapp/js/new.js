function check(){
	var data = document.t.data;
	if(isEmpty(data) || insNotNumber(data)){
		alert("���ڸ� �Է��Ͻÿ�");
		data.value="";
		data.focus();
		return false;
	}
	return true;
}