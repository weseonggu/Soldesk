
public class Menu {// final 붙으면 상속 자체 불가능
	String menu;
	int price;
	
	public void printInfo() {// final 붙으면 상속해도 오버라이드 불가능
		System.out.println(menu);
		System.out.println(price);
	}
	
}
