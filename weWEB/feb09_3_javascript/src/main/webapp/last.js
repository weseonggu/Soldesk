/**
 * 
 */
function test(){
	alert("zㅋㅋ");
	// 배열
	var ar = [123,12,122];
	alert(ar[0]);
	// 객체 -> 중괄호
	//{맴버 변수: 값,맴버 변수: 값...}
	var d ={name:"후추", age : 3};
	alert(d);
	alert(d.name);
}

function test2(){
	var ar=[
		{name : "홀길동", age:20},
		{name : "김길동", age:30},
		{name : "이길동", age:40}
		];
	for(var i =0 ; i<ar.length;i++){
		alert(ar[i].name+ ar[i].age);
	}
}

function test3(){
	//jquery javascript 쓰기 편하게 해놓은 라이브러리
	location.href="https:www.naver.com";// js로하는 get방식 요청
}