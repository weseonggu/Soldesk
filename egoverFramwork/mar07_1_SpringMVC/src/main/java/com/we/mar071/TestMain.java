package com.we.mar071;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestMain {

	public static void main(String[] args) {
		try {
			// 문자열로 된거 계산 하기
			// javaScript에있는 함수 가져와서 사용하는 방법
			ScriptEngineManager sem = new ScriptEngineManager();
			ScriptEngine se = sem.getEngineByName("JavaScript");
			int ans = (Integer) se.eval("10+2");
			System.out.println(ans);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
