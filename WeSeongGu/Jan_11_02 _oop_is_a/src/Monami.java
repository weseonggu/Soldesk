
public class Monami extends Goods{
	String color;
	
	public Monami() {
		// TODO Auto-generated constructor stub
	}

	public Monami(String name, int price, String maker, String color) {
		super(name, price, maker);
		this.color = color;
	}
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(color);
	}
	
	
}
