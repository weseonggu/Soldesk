function writeCheck(){
	var title = document.writeF.title;
	var txt = document.writeF.txt;
	 if(isEmpty(title)){
		alert("제목을 입력하세요");
		title.focus();
		return false;
	}
	if(isEmpty(txt)){
		alert("글을 쓰시오");
		txt.focus();
		return false;
	}
	return true;
}