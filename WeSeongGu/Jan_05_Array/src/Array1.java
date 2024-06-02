//배열운 참조형
public class Array1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] eng = new int[4];// 최초 버전 그다지 사용x, 사이즈변경x
		eng[0] = 90;
		eng[1] = 70;
		eng[2] = 80;
		eng[3] = 50;
		String[] name = new String[] { "mike", "lee", "rina" };// 개선 1 가끔 사용, 사이즈변경x
		int[] kor = { 90, 83, 56 };// 개선2 최근 안될 때도 있음 개선 1사용, 사이즈변경x

		System.out.println(kor.length);// 배열 길이
		System.out.println(kor);// heap영역 주소

		for (int i = 0; i < kor.length; i++) {
			System.out.println(kor[i]);
		}
		for (int i : kor) {// 배열을 차례대로 탐색 활용도는 낮음
			System.out.println(i);
		}
		
//-------------------------------------------------------------------------------------------------------------
		
	}
	
}
