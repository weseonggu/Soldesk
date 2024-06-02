
public class FireWall extends Goods {
	int port;

	public FireWall() {
		// TODO Auto-generated constructor stub
	}

	public FireWall(String name, int price, String maker, int port) {
		// super(); -> Goods 기본 생성자 호출
		super(name, price, maker); // Goods의 public Goods(String name, int price, String maker) 호출
		this.port = port;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(port);
	}

}
