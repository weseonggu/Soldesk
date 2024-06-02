
public class Human {
	// member, field variable, attribute (객체의 속성)
	String name;
	int age;


	// 객체 행동 -> 함수(메소드)
	public void eat() {
		System.out.println("냠");
	}
	
	// 프로그램에 필요한기능
	public void introduce() {
		System.out.println(this.name);
		System.out.println(age);// 자바버전올라가면서 this생략이 가능해짐
	}
	public int add(int a, int b) {
		return a+b;
	}
}
