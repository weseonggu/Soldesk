package com.we.jan13.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Doctor implements ActionListener {

	private JTextField textName;
	private JTextField textheight;
	private JTextField textweight;
	private JTextArea textresult;

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(JTextField textName, JTextField textheight, JTextField textweight, JTextArea textresult) {
		super();
		this.textName = textName;
		this.textheight = textheight;
		this.textweight = textweight;
		this.textresult = textresult;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = textName.getText();
		double height = Double.parseDouble(textheight.getText());
		double weight = Double.parseDouble(textweight.getText());

		System.out.println(name);
		System.out.println(height);
		System.out.println(weight);
		
		if (height > 3)
			height /= 100;
		
		double bmi = weight/(height*height);
		String r ="저체중";
		if (bmi>=35) {
			r="고도비만";
		}else if(bmi >=30) {
			r="중도비만";
		}else if(bmi >=25) {
			r="rud도비만";
		}else if(bmi >=23) {
			r="과체중";
		}else if(bmi >=18.5) {
			r="정상";
		}
		
		System.out.println(bmi);
		textresult.setText(name+"의 비만도는 "+r);

	}

}
