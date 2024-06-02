
public class Doctor {

	public void start() {
		Guest g = callGuest();
		ask(g);
		tellResult(g);
	}

	public Guest callGuest() {
		return new Guest();
	}

	public void ask(Guest g) {
		System.out.print("이름은: ");
		g.name = g.tellName();
		System.out.print("키: ");
		g.height = g.tellHW();
		if (g.height > 3) {
			g.height /= 100;
		}
		System.out.print("몸무게: ");
		g.weight = g.tellHW();
	}

	public void calculate(Guest g) {
		g.bmi= g.weight / (g.height * g.height);
		double b =g.bmi;
		if (b >= 35) {
			g.statues = "고도비만";
		} else if (b >= 30) {
			g.statues = "중도 비만";
		} else if (b >= 25) {
			g.statues = "경도비만";
		} else if (b >= 23) {
			g.statues = "과체중";
		} else if (b >= 18.5) {
			g.statues = "정상";
		} else {
			g.statues = "저체중";
		}
	}

	public void tellResult(Guest g) {
		System.out.println(g.height);
		System.out.println(g.bmi);
		System.out.printf("%s씨는 %s\n", g.name, g.statues);
	}
}
