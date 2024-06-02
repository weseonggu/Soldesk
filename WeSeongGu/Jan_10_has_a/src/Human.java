
public class Human {
	String name;
	String address;
	Dog pet;
	public Human() {
		// TODO Auto-generated constructor stub
	}
	public Human(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public Human(String name, String address, Dog pet) {
		super();
		this.name = name;
		this.address = address;
		this.pet = pet;
	}
	public void printInfo() {
		System.out.println(name);
		System.out.println(address);
		if(pet != null)// pet이 없는 사람만 수행
			pet.printInfo();
	}
}
