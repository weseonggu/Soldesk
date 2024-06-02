function joinCheck(){
	var id = document.joinF.id;
	var pw = document.joinF.pw;
	var pwC = document.joinF.pwCheck;
	var UN = document.joinF.uName;
	var ph = document.joinF.photo;
	
	if(isEmpty(id)||cotainHS(id)){
		alert("아이디를 입력하시오");
		id.value="";
		id.focus();
		return false;
	}
	if(isEmpty(pw)||cotainHS(pw)){
		alert("비밀번호 입력하시오");
		pw.value="";
		pw.focus();
		return false;
	}
	if((pw.value != pwC.value)){
		alert("비밀번호를 확인하시오");
		pwC.value="";
		pwC.focus();
		return false;
	}
	if(isEmpty(UN)){
		alert("이름을 입력하시오");
		UN.value="";
		UN.focus();
		return false;
	}
	if(isEmpty(ph)||(isNotType(ph,"jpg") && isNotType(ph,"png"))){
		alert("이미지파일을 선택해주세요");
		return false;
	}
	return true;
}






