// 상속 A is a B ex(taxi is a car)
public class OMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Milk m = new Milk();
		m.name = "서울 우유";
		m.price = 7000;
		m.printInfo();
		m.exDate = "내일";
		m.printInfo();
		System.out.println("-------------------------------------------------------------");

		Computer pc = new Computer();
		pc.name="스테이션";
		pc.price=500000;
		pc.cpu = "17-1234";
		pc.ram = 16;
		pc.hdd = 500;
		pc.printInfo();
		System.out.println("-------------------------------------------------------------");
		Motebook n = new Motebook();
		n.name="그램";
		n.price=2_500_000;
		n.cpu = "17-1234";
		n.ram = 16;
		n.hdd = 1000;
		n.weight=2;
		n.battery=500;
		n.printInfo();
	
	}

}
