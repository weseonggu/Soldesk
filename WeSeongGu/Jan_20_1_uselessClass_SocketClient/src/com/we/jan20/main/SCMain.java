package com.we.jan20.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SCMain {

	public static void main(String[] args) {
		Socket s = null;
		try {
			s = new Socket("192.168.0.11", 8787);// or 127.0.0.1 or localhost
			System.out.println("클라이언트: 접속성공");
			
			// 매새지 받기
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			// 메세지 보내기
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			// 받는 sub스레드
			Thread t = new Thread() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();
					super.run();
					JFrame jf = new JFrame();
					JTextArea jta = new JTextArea();
					jf.add(jta);
					jf.setLocation(500,0);
					jf.setSize(300, 300);
					jf.setVisible(true);
					while(true) {
						try {
							jta.append(br.readLine()+"\r\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			};
			t.start();
			// 보내는 스레드
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.print("뭐: ");
				String txt = sc.nextLine();
				bw.write(txt+"\r\n");
				bw.flush();
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
