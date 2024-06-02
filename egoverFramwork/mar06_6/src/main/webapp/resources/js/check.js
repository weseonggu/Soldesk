function check(){
	var n = document.f.name;
	var p= document.f.point;
	if(isEmpty(n)){
		alert("name");
		return false;
	}
	if(isEmpty(p)){
		alert("price");
		return false;
	}
	
	return true;
}