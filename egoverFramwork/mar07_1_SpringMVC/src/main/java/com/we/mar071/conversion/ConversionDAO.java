package com.we.mar071.conversion;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;

public class ConversionDAO {
	ScriptEngine se;
	ArrayList<ArrayList<String>> data;

	public ConversionDAO() {
		ScriptEngineManager sem = new ScriptEngineManager();
		se = sem.getEngineByName("JavaScript");
	}



	public void setData(ArrayList<ArrayList<String>> data) {
		this.data = data;
	}



	public void convert(double n, HttpServletRequest req) {
		try {
			ArrayList<UCResult> result = new ArrayList<UCResult>();
			for (ArrayList<String> arrayList : data) {
				result.add(new UCResult(arrayList.get(0), 
						(Double) se.eval(arrayList.get(1).replace("x", n + "")), 
						arrayList.get(2)
						));
			}
			req.setAttribute("convertResult", result);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
