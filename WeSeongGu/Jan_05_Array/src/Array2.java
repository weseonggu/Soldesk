
public class Array2 {
//String[] args 사용방법: 리눅스에서 실행할때 거기서 뒤에 파일 명을 지정을하면 그파일을 읽어서 분석함 변수에 지정해서 하면 그파일 만 실행하니 args를 이용함
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		System.out.println("------------------");
		for (String string : args) {
			System.out.println(string);
		}
		
		Thread.sleep(5000);
	}

}
