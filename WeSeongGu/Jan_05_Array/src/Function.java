// 2년있다가 회사를 옯길거지?
// 어떤일을 시키면 안되냐?
// 면접 질문
public class Function {
	// 							  main b주소  main c 주소
	private static void test(int a, int[] b, int[] c) {// call by value call by reference
		System.out.println(a);
		System.out.println(b[0]);// main의 b배열의 스택영역의 주소를 가짐
		System.out.println(c[0]);// 여기 까지는 c는 main의 스택영역의 c의 주소를 가짐
		a = 100;
		b[0] = 100;// 받아온 b의 주소를 가르킴
		// 힙영역에 새로운 주소 생성
		c = new int[] { 100, 200 };// heap영역에 새로운 주소를 만들고 100 200의 저장 c는 새로운 주소를 가진다.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int[] b = { 10, 20 };
		int[] c = { 10, 20 };
		test(a, b, c);
		System.out.println();
		System.out.println(a);// 변경x
		System.out.println(b[0]);// 10 -> 100
		System.out.println(c[0]);// 변경x

	}

}
