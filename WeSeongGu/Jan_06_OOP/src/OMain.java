import java.util.Scanner;

//객체지향프로그래밍 (object oriented programming)

//객체를 만들려면 클래스가 필요
//객체: 현실세계에 존제하는 무언가
public class OMain {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.name = "개";
		d.age = 4;
		d.bark();
		d.showInfo();
	}

}
