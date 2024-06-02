
public class OMain2 {
	public static void main(String[] args) {
		Meat m =new Meat();
		m.menu="한우";
		m.price=50000;
		m.cook="미디움";
		m.printInfo();
		m=null;// 메모리에서 지우기 스택에서 지우기 -> 힙에서 지우기 (가비지 콜랙션 실행)
		System.out.println("--------------------------------");
		Achool a =new Achool();
		a.menu="참이슬";
		a.price=4500;
		a.per=15;
		a.printInfo();
		a=null;// 메모리에서 지우기 스택에서 지우기 -> 힙에서 지우기 (가비지 콜랙션 실행)
	}
}
