// 생성자
// 		객체 생성시 하고싶은 작업
// 		메소드, 리턴이 없은 void도 없음, 매소드명이란 클래스 명이 같은걸 말함
public class Hongsam {
	String name;
	int price;
	static final String ORIGIN = "국산";
	
	//허공에 ctrl + space
	// 기본생성자 (default constructor) 
	//생성자 없으면 자바에서 컴파일 할때 자동으로 생성함
	//기본값을 주고 싶으면 사용
	public Hongsam() {
		System.out.println("입고됨");
		this.price=70000;
	}

	public void printInfo() {
		System.out.println(name);
		System.out.println(price);
		System.out.println(ORIGIN);
	}
}
