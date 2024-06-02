// JDK=JRE+개발킷
public class OMain {

	public static void main(String[] args) {
		Geajang.maker = "";

		Geajang g = new Geajang();
		g.name = "간장게장";
		g.weight = 10;
		g.price = 39900;
		g.showInfo();
		System.out.println("------------------------------");
		Geajang g1 = new Geajang();
		g1.name = "양념게장";
		g1.weight = 5;
		g1.price = 29900;
		g1.showInfo();
		System.out.println("------------------------------");
		Geajang.test();

	}

}
