function calcCheck(){
	var x = document.calcForm.xxx;
	var y = document.calcForm.yyy;
	if (isEmpty(x) || isEmpty(y)){
		alert("���ڸ� �Է��Ͻÿ�");
		x.value="";
		y.value="";
		x.focus();
		return false;
	}
	return ture;
}