package com.we.jan20.main;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GreenLine implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		JFrame jf = new JFrame();
		JTextArea jta = new JTextArea();
		jf.add(jta);
		jf.setLocation(500,0);
		jf.setSize(300, 300);
		jf.setVisible(true);
		
		for (int i = 0; i < 10; i++) {
			jta.append("ㅠㅠ\r\n");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
