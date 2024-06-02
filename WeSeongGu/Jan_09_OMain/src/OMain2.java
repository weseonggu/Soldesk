
public class OMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaterFountain w = new WaterFountain();

		w.hot = true;
		w.ice = true;
		w.name = "정수기";
		w.size = 50;

		w.intro();
		System.out.println("---------------------------");

		WaterFountain w1 = new WaterFountain();

		w1.hot = false;
		w1.ice = true;
		w1.name = "웅진";
		w1.size = 20;

		w1.intro();
		System.out.println("---------------------------");

		WaterFountain w2 = w;// 객체는 참조형으로 w의 주소를 w2에저장함
		w2.intro();
		System.out.println("---------------------------");
		w2.size = 10;
		w2.intro();// 그래서 w2에서 변경을 하면
		w.intro();// w에서도 변경하게 됨
		System.out.println(w);
		System.out.println(w2);
		// garbage collection
		// 발동시점 더이상 접근 불가능할 때 실행되어 힙영역의 데이터를 지운다.
		// 즉 프로그램이 종료되어 스택영역의 데이터가 지워지면 힙영역의 참조형 데이터에 접근이 불가능해진다. 
		// 그러면 garbage collection이 실행되어 힙영역의 데이터를 지운다
		
		w=null;
		w2=null; //이러면 스택영역의 변수에 저장된 주소가 사라지기 때문에 garbage collection이 수행됨
		// 사용처: 빅데이터 분석할때 필요없는 걸 지워서 메모리 공간을 확보 하기위해서 바로바로 null로 힙영역에서 지워 줘야한다.
	}

}
