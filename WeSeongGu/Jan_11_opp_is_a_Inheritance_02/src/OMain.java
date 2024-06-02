import java.util.Scanner;

public class OMain {
	public static void main(String[] args) {
		FireWall f =new FireWall("80F",0,"abcd",10);

		f.printInfo();
		System.out.println("--------------------------");
		
		Monami m= new Monami("모나미팬", 500, "모나미", "검정");
		m.printInfo();
		
		System.out.println("--------------------------");
		Mouse g = new Mouse("로지택123", 10000, "로지택 마우스");
		g.printInfo();

		System.out.println("--------------------------");
		Cannon c =new Cannon("캐논123", 500000, "캐논스캐너");
		c.printInfo();
		System.out.println("--------------------------");
		
		Scanner sc =new Scanner(System.in);
		System.out.print("what: ");
		String what = sc.next();
	}
}
