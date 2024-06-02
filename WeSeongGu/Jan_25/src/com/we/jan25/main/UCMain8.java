package com.we.jan25.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class UCMain8 {
	public static void main(String[] args) {
		BufferedReader br = null;
		HashMap<String, Long> hs = new HashMap<>();
		try {
			FileInputStream fis = new FileInputStream("D:\\Data/subway.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			String line = null;
			String lineNum = null;
			long io;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				lineNum = data[3];
				io = Integer.parseInt(data[5]) + Integer.parseInt(data[6]);
				hs.put(lineNum, hs.get(lineNum) == null ? 0 : hs.get(lineNum) + io); // hs.containsKey으로 키가 없으면 넣기 가능
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Set<String> ln= hs.keySet();
		ArrayList<String> al = new ArrayList<>(ln);
		Comparator<String> c = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};
		al.sort(c);
		for (String string : al) {
			System.out.println(string+": " + hs.get(string));
		}
		
	}
}
