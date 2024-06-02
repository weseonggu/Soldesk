package com.we.jan13.main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.we.jan13.action.Doctor;



public class OMain {
	public static void main(String[] args) {
		JFrame jf = new JFrame("비만도 검사");
		
		//GridLayout 4행 2열짜리
		
		GridLayout grid =new GridLayout(4, 2, 10, 10);
		jf.setLayout(grid);
		
		jf.add(new JLabel("이름: "));
		JTextField textName = new JTextField();
		jf.add(textName);
		
		jf.add(new JLabel("키: "));
		JTextField textheight = new JTextField();
		jf.add(textheight);
		
		jf.add(new JLabel("몸무게: "));
		JTextField textweight = new JTextField();
		jf.add(textweight);
		
		JButton result =  new JButton("확인");
		jf.add(result);
		
		JTextArea textresult = new JTextArea();
		jf.add(textresult);
//---------------------------------------------------------
		textName.getText();
		
		Doctor r= new Doctor(textName, textheight, textweight,textresult);
		result.addActionListener(r);
		jf.setSize(300, 300);
		
		jf.setVisible(true);
	}
}
