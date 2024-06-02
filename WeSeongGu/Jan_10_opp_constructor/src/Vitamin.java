
public class Vitamin {
	String name;
	int price;
	String type;
	int count;

	public Vitamin() {
		// TODO Auto-generated constructor stub
		System.out.println("비타민입고 됨");
	}

	// overloading된 생성자 우클릭 -> source(alt + shift + s) -> 밑에서 3번째
	public Vitamin(String name, int price, String type, int count) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.count = count;
	}

	public void printInfo() {
		System.out.println(name);
		System.out.println(price);
		System.out.println(type);
		System.out.println(count);
	}
}
