
public class PrintMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("gg");
		System.out.println("ㅠㅠ");
		System.out.println("ㅠㅠ");
		System.out.printf("%.2f",3.145123);
		System.out.println();
		System.out.println("---------------------------------");
		//new line
		System.out.println("지하철 \n 타고옴");
		//carriage return
		System.out.println("지하철 \r 타고옴");
		//제데로 엔터\r\n
		// \t tab 키
		System.out.println("\\(^^)/");
		System.out.println("이름:\t위성구");
		System.out.println("휴대폰:\t010-1234-1234");
		// \b 1byte 만큼 지우기 자바에서는 사용 불가 보통 한글자에 2bytes
		System.out.println("다음\b");
		System.out.println("위성구: \"아\"");
		System.out.println("---------------------------------");
		//format
		System.out.printf("이름: %s\n","위성구");
		System.out.printf("나이: %d\n",24);
		System.out.printf("기온: %d℃\n",-3);
		System.out.printf("기온: %02d℃\n",3);// 두자리 빈자리0으로 채우기 
		System.out.printf("기온: %.3f\n",213.46841);//반올림
		System.out.printf("습도: %.0f%%\n",20.345);
	}

}
