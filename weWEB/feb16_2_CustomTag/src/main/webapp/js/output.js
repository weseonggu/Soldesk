function check(){
	var f =document.fff.swing;
	if (isEmpty(f) || three(f) || eq(f)){
		alert("세자릿수 숫자를 입력 하시오");
		f.value="";
		f.focus();
		return false;
	}
	return true;
}

function three(input){
	return !(input.value>=100 && input.value<1000);
}
function eq(input){
	if(input.value.charAt(0) == input.value.charAt(1)||
	input.value.charAt(0) == input.value.charAt(2)||
	input.value.charAt(1) == input.value.charAt(2)
	){
		return true;
	}
	else{
		return false;
	}
}