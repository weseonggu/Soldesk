function check(){
	var name = document.f.n;
	var price = document.f.p;
	if(isEmpty(name)){
		alert("상품이름");
		return false;
	}
	if(isEmpty(price)){
		alert("상품가격");
		return false;
	}
	return true;
}