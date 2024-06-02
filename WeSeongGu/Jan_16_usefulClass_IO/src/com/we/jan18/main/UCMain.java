package com.we.jan18.main;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

// Outputstream : 1byte
// OnputstreamReader : 2byte
// BufferedWirter : 1String(줄단위)

// Inputstream 1byte
// InputstreamWriter 2byte
// BufferedReader : 1String(줄단위)

public class UCMain {

	public static void main(String[] args) {
		InputStream is = System.in;
		// 1.5때부터 추가된 InputStream 서포터
		
		
		Scanner sc = new Scanner(is);
		PrintStream ps = System.out;
	}

}
