function writeCheck(){
	var title = document.writeF.title;
	var txt = document.writeF.txt;
	 if(isEmpty(title)){
		alert("������ �Է��ϼ���");
		title.focus();
		return false;
	}
	if(isEmpty(txt)){
		alert("���� ���ÿ�");
		txt.focus();
		return false;
	}
	return true;
}