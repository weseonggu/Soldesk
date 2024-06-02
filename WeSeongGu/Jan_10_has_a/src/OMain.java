// 객체간의 관계
// A has a B
// A is a B
public class OMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog("후추", 3);
		dog.printInfo();
		System.out.println("--------------------------");
		Human h = new Human("위성구", "노원구");
		h.printInfo();
		//pet.printInfo(); 가 실행이 안됨

		System.out.println("--------------------------");
		Human h2 = new Human("김길동", "노원구",dog);
		h2.printInfo();
		
		System.out.println("--------------------------");
		Company c=new Company("삼성", 50, h2);
		c.printInfo();
		System.out.println("--------------------------");
		Phone p=new Phone("플립", 0, c);
		p.printInfo();
		System.out.println("--------------------------");
		System.out.println(p.name);
		System.out.println("--------------------------");
		System.out.println(p.sam.name);
		System.out.println("--------------------------");
		p.sam.printInfo();
		System.out.println("--------------------------");
		System.out.println(p.sam.h.address);
		System.out.println(p.sam.h.printInfo());
		System.out.println();
		System.out.println();
	}

}
