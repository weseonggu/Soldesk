
public class Computer extends Goods {
	String cpu;
	int ram;
	int hdd;
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(cpu);
		System.out.println(ram);
		System.out.println(hdd);
	}	
}
