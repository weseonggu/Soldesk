function joinCheck(){
	var id = document.joinF.id;
	var pw = document.joinF.pw;
	var pwC = document.joinF.pwCheck;
	var UN = document.joinF.uName;
	var ph = document.joinF.photo;
	
	if(isEmpty(id)||cotainHS(id)){
		alert("���̵� �Է��Ͻÿ�");
		id.value="";
		id.focus();
		return false;
	}
	if(isEmpty(pw)||cotainHS(pw)){
		alert("��й�ȣ �Է��Ͻÿ�");
		pw.value="";
		pw.focus();
		return false;
	}
	if((pw.value != pwC.value)){
		alert("��й�ȣ�� Ȯ���Ͻÿ�");
		pwC.value="";
		pwC.focus();
		return false;
	}
	if(isEmpty(UN)){
		alert("�̸��� �Է��Ͻÿ�");
		UN.value="";
		UN.focus();
		return false;
	}
	if(isEmpty(ph)||(isNotType(ph,"jpg") && isNotType(ph,"png"))){
		alert("�̹��������� �������ּ���");
		return false;
	}
	return true;
}






