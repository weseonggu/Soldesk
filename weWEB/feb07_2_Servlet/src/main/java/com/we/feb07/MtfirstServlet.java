package com.we.feb07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet(Server + Applet) 서버(was)에서 실행되는 프로그램
//클라이언트 한테 요청 받으면, 
//html/css를 만들어서 응답해주는
//자바 프로그램

// @xxx :annotation
//		xxx에 무엇이 있는 냐애 따라 다다름
// 		대부분은 [원래 수동설정을 해야하는데, annotaion쓰면 자동]



// 원래; 서블랫을 만들면 톰캣에 등록해야 쓸수 있음
// 업데이트로 톰캣에 자동으로 등록 지우지 말기!!! 변경을 refactor로하고 위는 직접 변경해야함
/**
 * Servlet implementation class MtfirstServlet
 */
@WebServlet("/MtfirstServlet")
public class MtfirstServlet extends HttpServlet {
	//HttpServlet의 기능 다 물려 받고 + 기능 추가
	
	//작업하면서 버전 표시하라고 만들어준거 필요없음
	private static final long serialVersionUID = 1L;
    
	// 생성자
	// 객체 만들어 질때 뭐하려면
	// 언제 만들어 지나 :tomcat이 알아서 함
	// main이 tomcat에 있음
	
	//tomcat이 실행중
	//		tomcat이 MyFirstServlet 객체를 만들고
	//		tomcat이 꺼질때 까지 무한 루프를돌다가
	//		클라이언트 요청 받은거 처리해주고 무한 루프로 복귀
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MtfirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    // 이벤트 루프 돌다가 
    // 클라이언트로부터 GET방식 요청받으면
    // tomcat이 알아서 이거 호출함
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpServletRequest request 요청객체 
		//HttpServletResponse response 응답 객체
		System.out.println("누가 GET방식 요청함?");
		
		//서버는 : ㅋ -???->(어떤 방식으로 인코딩 있나)
		response.setCharacterEncoding("EUC-KR");
		//클라이언트는 서버에서 받을걸 어떤 방식으로 디코딩하는가
		Random r = new Random();
		int x = r.nextInt(10);

		
		//서버와 클라이언트 사이의 랜선에 붙어 있는 응답용 빨대
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset=\"EUC-KR\"><title>Insert title here</title></head><body>"); // 응답 변수없이 그냥 넣어 됨
		pw.print("<h1>ㅋㅋㅋㅋㅋ</h1>");
		pw.printf("<marquee>%d</marquee>",x);
		pw.print("</body></html>");
	}
	// 안터넷
	// 	주소를 알고 있어서 직접 처서 : GET방식 요청
	//	검색해서 클릭으로 들어가면 <a href=""></a>:GET방식 요청
	// 대부분은 GET방식
	// POST방식은 특병한 기술로만 가능
	
	
    // 이벤트 루프 돌다가 
    // 클라이언트로부터 POST방식 요청받으면
    // tomcat이 알아서 이거 호출함
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("누가 POST방식 요청함?");
	}

}
