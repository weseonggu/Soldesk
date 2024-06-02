package com.we.jan13.main;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.we.jan13.hero.Herk;

public class OMain2 {
	public static void main(String[] args) {
		JFrame p = new JFrame("지구");
		JButton h = new JButton("홍길동");
//		JTextField h = new JTextField("zzzz");
//		JFileChooser h = new JFileChooser();
		p.add(h);
		
		Herk i = new Herk();
		h.addActionListener(i);
		
		p.setSize(300, 300);
		p.setVisible(true);
	}

}