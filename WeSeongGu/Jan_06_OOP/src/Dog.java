
public class Dog {

	// 속성
	String name;
	int age;

	// 행동 -> 함수
	public void bark() {
		System.out.println("멍");
	}

	// 프로그램상 필요한 기능 -> 함수로구현
	public void showInfo() {
		System.out.println(name);
		System.out.println(age);
	}

}
