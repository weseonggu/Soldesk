function bye(){
	var ready = confirm("탈퇴 할실건가요?");
	if(ready){
		location.href="ByeController";
	}
}

function infoCheck(){
	var changePW = document.infoF.changPW;
	var PWCheck = document.infoF.PWCheck1;
	var changePhoto = document.infoF.changePhoto;
	if((changePW.value == "") && (changePhoto.value == "")){
		alert("변경할 정보가 없습니다.");
		return false;
	}
	if(changePW.value != ""){
		if(changePW.value != PWCheck.value){
			alert("변경한 비번을 확인하세요.");
			return false;
		}
	}
	if(changePhoto.value != ""){
		if(isNotType(changePhoto,"jpg") && isNotType(changePhoto,"png")){
			alert("이미지파일을 선택해주세요");
			return false;
		}
	}
	
	return true;
}