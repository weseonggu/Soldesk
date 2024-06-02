function check(){
	var x = document.fff.xx;
	var y = document.fff.yy;
	if(isEmpty(x)||isEmpty(y)
		|| isNotNumber(x)||isNotNumber(y)){
		alert("¼ýÀÚ");
		x.value="";
		y.value="";
		return false;
	}
	return true;
}
function moreBig(){
		var x = document.getElementById("xx1").value;
		var y = document.getElementById("yy1").value;
		if(x>y){
			alert(x);
		}else{
			alert(y);
		}
}