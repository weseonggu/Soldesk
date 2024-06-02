// 생성자
// 		객체 생성시 하고싶은 작업
// 		메소드, 리턴이 없은 void도 없음, 매소드명이란 클래스 명이 같은걸 말함
public class OMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hongsam h = new Hongsam();
		h.name = "세트";
		h.price = 100000;
		h.printInfo();
		System.out.println("-------------------------------------");
		Vitamin v= new Vitamin();
		v.name="비타민c";
		v.price=50000;
		v.type="알약";
		v.count=70;
		v.printInfo();
		System.out.println("-------------------------------------");
		//객체를 만들면서 값까지 설정
		Vitamin v1 = new Vitamin("c", 60000, "jelly", 90);
		v1.printInfo();
	}

}

