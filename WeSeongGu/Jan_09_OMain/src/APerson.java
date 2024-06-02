import java.util.Random;

public class APerson {
	Random r = new Random();
	/**
	 * 
	 * @return 어떤한것이 리턴되애하는지 설명
	 */
	public int rsp() {
		return r.nextInt(3) + 1;
	}
}
