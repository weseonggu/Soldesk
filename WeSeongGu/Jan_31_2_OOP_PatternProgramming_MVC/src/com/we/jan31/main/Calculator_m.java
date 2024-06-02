package com.we.jan31.main;

import java.util.ArrayList;

public class Calculator_m {
	public static CalcResult name(ArrayList<Integer> ar) {
		int x = ar.get(0);
		int y = ar.get(1);
		int q = x+y;
		int w = x-y;
		int e = x*y;
		int r = x/y;
		return new CalcResult(q, w, e, r);
	}
}
