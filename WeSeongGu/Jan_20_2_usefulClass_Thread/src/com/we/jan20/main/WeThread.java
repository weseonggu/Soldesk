package com.we.jan20.main;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class WeThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		JFrame jf = new JFrame();
		JTextArea jta = new JTextArea();
		jf.add(jta);
		jf.setSize(300, 300);
		jf.setVisible(true);
		
		for (int i = 0; i < 10; i++) {
			jta.append("ㅎ\r\n");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
