function check() {
	var n = document.fff.nnn;
	var h = document.fff.hhh;
	var w = document.fff.www;
	var p = document.fff.photo;

	if (isEmpty(n)) {
		alert("�̸��� �����ÿ�");
		n.value = "";
		n.focus();
		return false;
	}

	if (isEmpty(h) || isNotNumber(h) || isCM(h)) {
		alert("Ű�� �����ÿ�");
		h.value = "";
		h.focus();
		return false;
	}
	if(isEmpty(w) || isNotNumber(w)|| isCM(w)){
		alert("�����Ը� �����ÿ�");
		w.value = "";
		w.focus();
		return false;
	}
	if(isEmpty(p)||(isNotType(p,"jpg") && isNotType(p,"gif") && isNotType(p,"png"))){
		alert("������� �ٶ��ϴ�.");
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