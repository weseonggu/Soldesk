package com.we.jan25.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class UCMain7 {
	public static void main(String[] args) {
		BufferedReader br = null;
		HashMap<String, Long> hs = new HashMap<>();
		SimpleDateFormat chaneToDate = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat changeToYoil = new SimpleDateFormat("E");
		try {
			FileInputStream fis = new FileInputStream("D:\\Data/subway.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");// euc-kr로 하면 문제 발생 이유 쓸때 utf-8로 했기 때문에
			br = new BufferedReader(isr);
			String line = null;
			String yoil = null;
			long io;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				yoil = changeToYoil.format(chaneToDate.parse(data[0] + data[1] + data[2]));
				io = Integer.parseInt(data[5]) + Integer.parseInt(data[6]);
				hs.put(yoil, hs.get(yoil) == null ? 0 : hs.get(yoil) + io);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("월: " + hs.get("월"));
		System.out.println("화: " + hs.get("화"));
		System.out.println("수: " + hs.get("수"));
		System.out.println("목: " + hs.get("목"));
		System.out.println("금: " + hs.get("금"));
		System.out.println("토: " + hs.get("토"));
		System.out.println("일: " + hs.get("일"));
	}
}
