package com.kosa.game.main;

import com.kosa.game.irman.Irman;

// 상사가 인터페이스로 만들어야하는 거 만듬 그러면 밑에 직원이 implemant로 받아서 구현한다음 
// 인터페이스랑 만든 클래스를 jar파일과 doc문서를 만들어서 상사에게 전달함 이런식으로 일을 함
public class GMain {
	public static void main(String[] args) {
		Irman i = new Irman();
		i.shootBeam();
	}
}
