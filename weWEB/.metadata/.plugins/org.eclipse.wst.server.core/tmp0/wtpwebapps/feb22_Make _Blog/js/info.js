function bye(){
	var ready = confirm("Ż�� �ҽǰǰ���?");
	if(ready){
		location.href="ByeController";
	}
}

function infoCheck(){
	var changePW = document.infoF.changPW;
	var PWCheck = document.infoF.PWCheck1;
	var changePhoto = document.infoF.changePhoto;
	if((changePW.value == "") && (changePhoto.value == "")){
		alert("������ ������ �����ϴ�.");
		return false;
	}
	if(changePW.value != ""){
		if(changePW.value != PWCheck.value){
			alert("������ ����� Ȯ���ϼ���.");
			return false;
		}
	}
	if(changePhoto.value != ""){
		if(isNotType(changePhoto,"jpg") && isNotType(changePhoto,"png")){
			alert("�̹��������� �������ּ���");
			return false;
		}
	}
	
	return true;
}