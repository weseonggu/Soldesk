import java.util.Random;

//실전 상속 사용 법
public class WeRandom extends Random {
	@Override
	public int nextInt(int bound) {
		// TODO Auto-generated method stub
		int x = super.nextInt(bound);
		return x % 2 == 0 ? nextInt(bound) : x;
	}
}
