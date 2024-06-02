// 변수
// byte short int long
// float double
// char String
// boolean
// void
// 기본형 stack 영역에 저장 메모리 반환 자동
// 참조형은 heap 영역에 저장 메모리 반환 자동 아님(개발자가 풀어 주어야 한다.) 
//garbage collection heap영역 자동 메모리 반환 시스템 

public class Variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height = 180;
		byte age = 24;
		System.out.printf("키: %d\n", height);
//		System.out.printf("나이: %d\n",age);
		System.out.println("나이: " + age);
		double aaa = 2.0; // float는 오류 자바의 기본 자료형(데이터만 딱있을 때 자바가 보는 데이터형을 말함) float 쓰고 싶으면 f 붙이먄 사용가능
		System.out.println("시력: " + aaa); // 변수명 바꾸기 우클릭 Refactor
		char c = 'a';// 한글자는 ''로 사용
		String name = "위성구";// 한글자 가능 String은 참조형
		 
		boolean cold = true;
	}

}
