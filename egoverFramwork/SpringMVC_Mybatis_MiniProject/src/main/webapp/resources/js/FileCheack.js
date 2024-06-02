function fileCheck(){
	var file =document.fileform.bd_file;
	if(isEmpty(file)){
		alert("파일 선택");
		return false;
	}
	return true;
}