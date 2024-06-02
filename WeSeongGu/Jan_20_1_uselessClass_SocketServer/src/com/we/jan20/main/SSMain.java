package com.we.jan20.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

// socket
// socket 통신: ip주소 - DNS서버
// ip주소 192.168.0.11
// 
public class SSMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss = null;
		
		
		try {
			ss = new ServerSocket(8787);
			System.out.println("서버: 대기중");
			Socket s = ss.accept();
			System.out.println("서버: 누가 접속함");
			// 매새지 받기
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			// 메세지 보내기
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			Scanner sc = new Scanner(System.in);
			// 받는 sub스레드
			Thread t = new Thread() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
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
			while (true) {
				System.out.print("뭐: ");
				String txt = sc.nextLine();
				bw.write(txt+"\r\n");
				bw.flush();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		try {
			ss.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
