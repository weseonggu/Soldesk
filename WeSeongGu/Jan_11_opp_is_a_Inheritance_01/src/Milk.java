//milk의 상위, super, 부모클래스: Goods
//Goods의 하위, 자식클래스: Milk


// 상속 : 하위 크래스에서 뭔가 추가
public class Milk extends Goods {
	// Goods에있는 맴버를 물려 받아서 사용이 가능
	String exDate;
	
	//물려 받아온 printInfo 기능을 변경하고 싶음 
	// 물려 받아온 메소드를 재정의 ->  overriding
	// overloading vs overriding ?
	
	// @xxxx : annotation (xxxx에뭐가 들어가는냐에 따라 다름) 대부분 따로 작업해야하는데, 자동으로 처리해줌
	// @Override 밑에는 override된 메소드만 있어야함 일반 다른 일반 메소드가 있으면 에러 뜸
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();// super 상위 클래스 Goods에있는 printInfo()
		System.out.println(exDate);
	}
}
