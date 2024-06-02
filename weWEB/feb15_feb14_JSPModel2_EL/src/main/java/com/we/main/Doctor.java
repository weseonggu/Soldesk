package com.we.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//맴버 변수가 없다 -> 저장할 공간이 필요없다
// 객체를 생성 할 필요가 없다 -> static으로 메소드를 만든다
// static메소드에 일반 맴버 변수는 쓸수 없다.
// 일반적인 클래스를 만드면
// post를 요청 할때마다 객체를 생성하면 메모리가 낭비 됨
// 그래서 맴버 변수가 필요없으면 static메소드를 사용하고
// 맴버 변수가 필요하면 singleton 패턴을 사용한다.

// 일반 맴버 변수 a가 있는 싱글턴 패턴의 클래스가 있는데 
// A유저와B유저가 접속함
// A가 맴버 변수a를 10으로 설정하고 사용하지 전에 B가 a를 20으로 
// 변경하면 A의 의도인 10이 아니라 20이 사용된다.

public class Doctor {
	private static final Doctor DOCTOR = new Doctor();

	private Doctor() {

	}

	public static Doctor getDoctor() {
		return DOCTOR;
	}

	public void calculator(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("EUC-KR");

			String path = request.getSession().getServletContext().getRealPath("img");
			MultipartRequest mr = new MultipartRequest(request, // 기존 요청객체
					path, // 파일이 업로드 될 폴더 절대경로
					10 * 1024 * 1024, // 파일 용량 제한(넘기면 exception) 바이트 단위
					"euc-kr", // 요청 파라메터 인코딩 방식
					new DefaultFileRenamePolicy()// 파일명 중복처리
			);
			String fname = mr.getFilesystemName("photo");
			fname = URLEncoder.encode(fname, "euc-kr");
			fname = fname.replace("+", " ");

			String name = mr.getParameter("nnn");
			double h = Double.parseDouble(mr.getParameter("hhh"));
			double w = Double.parseDouble(mr.getParameter("www"));

			double hh = h / 100;
			double bmi = w / (hh * hh);
			bmi = Math.round(bmi * 100) / 100.0;
			String result = "저체중";
			if (bmi >= 35) {
				result = "고도비만";
			} else if (bmi >= 30) {
				result = "중도 비만";
			} else if (bmi >= 25) {
				result = "경도 비만";
			} else if (bmi >= 23) {
				result = "정상";
			}
			System.out.println(name);
			System.out.println(h);
			System.out.println(w);
			System.out.println(fname);
			System.out.println(bmi);
			System.out.println(result);
			Guest g= new Guest(name, h, w, fname, bmi, result);
			request.setAttribute("guest", g);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
