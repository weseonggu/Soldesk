//상위클래스랑 같은 생성자가 같고 싶으면 희귀한 상황
public class Mouse extends Goods {

	public Mouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mouse(String name, int price, String maker) {
		super(name, price, maker);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
	}
	
}
