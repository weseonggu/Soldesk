/**
 * 
 */
function test(){
	alert("z����");
	// �迭
	var ar = [123,12,122];
	alert(ar[0]);
	// ��ü -> �߰�ȣ
	//{�ɹ� ����: ��,�ɹ� ����: ��...}
	var d ={name:"����", age : 3};
	alert(d);
	alert(d.name);
}

function test2(){
	var ar=[
		{name : "Ȧ�浿", age:20},
		{name : "��浿", age:30},
		{name : "�̱浿", age:40}
		];
	for(var i =0 ; i<ar.length;i++){
		alert(ar[i].name+ ar[i].age);
	}
}

function test3(){
	//jquery javascript ���� ���ϰ� �س��� ���̺귯��
	location.href="https:www.naver.com";// js���ϴ� get��� ��û
}