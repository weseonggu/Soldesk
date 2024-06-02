//static 맴버 변수:
//		객체들의 공통 속성에 사용하는거
//		객체가 없이도 사용가능
// jvm이 OMain.main을 자동 호출(jvm이 클래스의 main을 자동으로 실행 함)
public class Geajang {
	String name;
	int weight;
	int price;
	static String maker="김수미";//static 붙여야 하는 이유: static영역에 생성해서 힙영역에는 maker자리가 없이 static영역을 공유해서 사용
	// final 붙으면 값 변경 불가능(약속: final붙으면 변수 다 대문자로 선언)
	//	String maker="김수미"; 사용x
	
	public void showInfo() {
		System.out.println(name);
		System.out.println(weight);
		System.out.println(price);
		System.out.println(maker);
	}
	
	public static void test() {// static method 객체 없이도 사용가능 이거때문에 사용, static이 아닌거 사용못함
		System.out.println("태스트");
	}
}
