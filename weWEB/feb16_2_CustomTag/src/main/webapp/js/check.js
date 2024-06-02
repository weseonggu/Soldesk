function calcCheck(){
	var x = document.calcForm.xxx;
	var y = document.calcForm.yyy;
	if (isEmpty(x) || isEmpty(y)){
		alert("수자를 입력하시오");
		x.value="";
		y.value="";
		x.focus();
		return false;
	}
	return ture;
}