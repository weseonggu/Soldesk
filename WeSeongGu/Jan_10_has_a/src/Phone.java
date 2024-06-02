
public class Phone {
	String name;
	int price;
	Company sam;
	
	public Phone() {
		// TODO Auto-generated constructor stub
	}


	
	public Phone(String name, int price, Company sam) {
		super();
		this.name = name;
		this.price = price;
		this.sam = sam;
	}



	public void printInfo() {
		System.out.println(name);
		System.out.println(price);
		sam.printInfo();
	}
}
