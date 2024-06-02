package com.we.mar072.convert;

import java.util.HashMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;

//@Service
public class ConvertDAO {
	HashMap<String, String> danwiMap;
	HashMap<String, String> priorDanwi;

	public ConvertDAO() {
//		danwiMap = new HashMap<String, Double>();// 니중에 등록
//		danwiMap.put("inch", 0.393701);
//		danwiMap.put("㎡", 3.305785);
//		priorDanwi = new HashMap<String, String>();
//		priorDanwi.put("inch", "cm");
//		priorDanwi.put("㎡", "평");
	}

	public void convertNum(UCResult ur, HttpServletRequest req) {
		try {
			ScriptEngineManager sem = new ScriptEngineManager();
			ScriptEngine se = sem.getEngineByName("JavaScript");
			double result;
			result = (Double) se.eval(danwiMap.get(ur.getDanwi()).replace("x", ur.getNum() + ""));
			UCResult send = new UCResult(ur.getNum(), ur.getDanwi(), priorDanwi.get(ur.getDanwi()), result,
					ur.getDanwi());
			req.setAttribute("result", send);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setDanwiMap(HashMap<String, String> danwiMap) {
		this.danwiMap = danwiMap;
	}

	public void setPriorDanwi(HashMap<String, String> priorDanwi) {
		this.priorDanwi = priorDanwi;
	}

}
