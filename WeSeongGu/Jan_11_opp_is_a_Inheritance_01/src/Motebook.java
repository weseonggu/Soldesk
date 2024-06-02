
public class Motebook extends Computer{// 다단 상속
	double weight;
	int battery;
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(weight);
		System.out.println(battery);
	}

}
