
public class Company {
	String name;
	int woker;
	Human h;
	public Company() {
		// TODO Auto-generated constructor stub
	}
	
	public Company(String name, int woker, Human h) {
		super();
		this.name = name;
		this.woker = woker;
		this.h = h;
	}

	public void printInfo() {
		System.out.println(name);
		System.out.println(woker);
		h.printInfo();
		
	}
}
