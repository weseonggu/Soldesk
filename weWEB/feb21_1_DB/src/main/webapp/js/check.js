function check(){
	var name = document.f.n;
	var price = document.f.p;
	if(isEmpty(name)){
		alert("��ǰ�̸�");
		return false;
	}
	if(isEmpty(price)){
		alert("��ǰ����");
		return false;
	}
	return true;
}