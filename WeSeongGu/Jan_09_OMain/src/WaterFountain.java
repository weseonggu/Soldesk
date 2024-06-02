
public class WaterFountain {
	String name;
	int size;
	boolean ice;
	boolean hot;
	
	public void intro() {
		System.out.println("이름: "+name);
		System.out.println("용량: "+size+"L");
		System.out.println("얼음: "+(ice ? "o":"x"));
		System.out.println("뜨거운 물: "+(hot? "o":"x"));
	}
}
