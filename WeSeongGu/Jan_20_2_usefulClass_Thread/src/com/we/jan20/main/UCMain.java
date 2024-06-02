package com.we.jan20.main;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class UCMain {
// JVM이 thread를 만들어서  main으로 보냄
	
// multi-thread programming
	// jvm이 만든 스레드 -> main thread
	// 사람이 만든 sub thread(main 스레드에서 스래드를 생성해서 실행함)
	public static void main(String[] args) {
		// 방1
		WeThread wt = new WeThread();
		wt.start();// 새로운 스래드를 먼들어서 run으로 보내기
		// 방2
		Thread t = new Thread( new GreenLine());
		t.start();
		// 방3
		Thread t2 = new Thread() {
			@Override
			public void run() {
				super.run();
				
				JFrame jf = new JFrame();
				JTextArea jta = new JTextArea();
				jf.add(jta);
				jf.setLocation(1000,0);
				jf.setSize(300, 300);
				jf.setVisible(true);
				
				for (int i = 0; i < 10; i++) {
					jta.append("ㄱㄱ\r\n");
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t2.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("z");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
