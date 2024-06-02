//현실에 존재하는 무언가: 객체
//클래스: 객체를 만들기 위해 필요한거
//클래스안에서 쓰는건 메소드라고 함
// 함수는 클래스 밖에서 사용하면 함수라고함
//자바에는 함수가 없음 메소드가 있음

public class OMain {

	public static void main(String[] args) {// main 함수 -> x main메소드 -> O
		// TODO Auto-generated method stub
		Human h = new Human();
		h.name = "위성구";
		h.age = 25;
		h.eat();
		h.introduce();

		Human h1 = new Human();

		h1.name = "김길동";
		h1.age = 30;
		h1.introduce();

		Calculator cal = new Calculator();
		cal.modelName = "카시오2134";
		cal.price = 34500;
		cal.introduce();

		cal.add(2, 5);
		

	}

}
