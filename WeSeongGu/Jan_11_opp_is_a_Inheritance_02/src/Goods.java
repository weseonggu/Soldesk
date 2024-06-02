//하위 클래스로 객체를 만들면 상위 클레스의 기본 생성자를 자동으로 부른다.

//생성자는 상속이 안됨
public class Goods {
	String name;
	int price;
	String maker;
	
	public Goods() {
		// TODO Auto-generated constructor stub
	}

	public Goods(String name, int price, String maker) {
		super(); // 기본 생성자를 자동으로 부름 없어도 실행됨
		this.name = name;
		this.price = price;
		this.maker = maker;
	}


	public void printInfo() {
		System.out.println(name);
		System.out.println(price);
		System.out.println(maker);
	}
}
