function check() {
	var n = document.fff.nnn;
	var h = document.fff.hhh;
	var w = document.fff.www;
	var p = document.fff.photo;

	if (isEmpty(n)) {
		alert("이름을 적으시오");
		n.value = "";
		n.focus();
		return false;
	}

	if (isEmpty(h) || isNotNumber(h) || isCM(h)) {
		alert("키를 적으시오");
		h.value = "";
		h.focus();
		return false;
	}
	if(isEmpty(w) || isNotNumber(w)|| isCM(w)){
		alert("몸무게를 적으시오");
		w.value = "";
		w.focus();
		return false;
	}
	if(isEmpty(p)||(isNotType(p,"jpg") && isNotType(p,"gif") && isNotType(p,"png"))){
		alert("사진등록 바랍니다.");
		return false;
	}
	return true;
}
function isCM(input) {
	if (input.value < 3) {
		return true;
	} else {
		return false;
	}
}