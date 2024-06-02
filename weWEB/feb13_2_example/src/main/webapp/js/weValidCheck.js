function isEmpty(input){// id비어 있는지 검사
	return !input.value;
}

function cotainHS(input){// id 영어 숫자 일부 특수 문자 를 제외한 글자가 있는지 검사
	input.value
	var ok = "qwertyuiopasdfghjklzxcvbnm1234567890!@#$%^&*_.-";
	for (var i =0 ; i<input.value.length; i++){
		if(ok.indexOf(input.value[i])== -1) {
			return true;
		}
	}
}

function lessThan(input, len){
	return input.value.length<len;
}

function notContains(input, set){
	for (var i=0; i<set.length; i++){
		if(input.value.indexOf(set[i]) != -1){
			return false;
		}
	}
	return true;
}

function notEquals(input1,input2){
	return input1.value != input2.value;
}

function isNotNumber(input){
	return (input.value.indexOf(" ")!= -1 || isNaN(input.value));
}

function isNotType(input,type){
	type = "."+type;
	return input.value.toLowerCase().indexOf(type) == -1;
}
