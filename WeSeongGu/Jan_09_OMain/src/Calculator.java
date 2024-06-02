
//
public class Calculator {
	String modelName;// 기본 값이 있어서 초기화 없어도 사용가능 숫자 -> 0, 참조형 -> null
	int price;

	public void introduce() {
		System.out.println(modelName);
		System.out.println(price);
	}

	public void add(int a, int b) {
		int z=a+b;//지역변수는 초기화하고 나서 사용해야한다.
		System.out.println(z);
	}
}
