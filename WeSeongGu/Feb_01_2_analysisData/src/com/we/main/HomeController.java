package com.we.main;

import java.util.ArrayList;

public class HomeController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<AvgDust> arr = GetDate_M.getDataToDB();
		ShowData_V.showdata(arr);
	}

}
