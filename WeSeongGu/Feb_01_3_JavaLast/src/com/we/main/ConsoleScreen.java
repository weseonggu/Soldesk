package com.we.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.we.needclass.Product;
import com.we.needclass.Search;
import com.we.needclass.StoreData;

public class ConsoleScreen {
	private Scanner s;

	public ConsoleScreen() {
		s = new Scanner(System.in);
	}

	private void showMenu() {
		System.out.println("--------------------");
		System.out.println("1. 편의점 등록");
		System.out.println("2. 물건 등록");
		System.out.println("3. 전체 조회");
		System.out.println("4. 물건 조회");
		System.out.println("5. 편의점 조회");
		System.out.println("6. 상품 파는 편의점 조회");
		System.out.println("10. 종료");
		System.out.println("--------------------");
	}

	public int whatDo() {
		showMenu();
		System.out.print("뭐: ");
		return s.nextInt();
	}
	// 1번
	public StoreData showRegCVSMenu() {
		System.out.print("편의점 이름: ");
		String n = s.next();
		System.out.print("지점명: ");
		String j = s.next();
		System.out.print("주소: ");
		String l = s.next();
		return new StoreData(n, j, l);
	}
	//2번
	public Product showProduct(ArrayList<StoreData> arr) {
		System.out.print("유통기한[YYYYMMDD]: ");
		String exp = s.next();
		System.out.print("상품명: ");
		String name = s.next();
		System.out.print("가격: ");
		int price = s.nextInt();

		for (StoreData i : arr) {
			System.out.print(i.getCvsNum() + ". " + i.getJijum() + " ");
		}
		System.out.print("\n판매하는 편의점: ");
		int cvs = s.nextInt();
		return new Product(exp, name, price, cvs);
	}
	//1번 3번 4번 5번
	public int getPage(int p) {
		System.out.print("보고싶은 페이지를 입력하시오(총 " + p + "페이지) :");
		return s.nextInt();
	}
	//3번
	public void showSearch(ArrayList<Search> arr) {
		for (Search search : arr) {
			search.showInfoAll();
		}
	}
	//4번
	public void showSearch2(ArrayList<Search> arr) {
		for (Search search : arr) {
			search.showSnackAll();
		}
	}
	//5번
	public void showSearch3(ArrayList<Search> arr) {
		for (Search search : arr) {
			if (arr == null)
				continue;
			search.showSnackAll2();
		}
	}
	//6번
	public void showSearch4(ArrayList<Search> arr) {
		for (Search search : arr) {
			if (arr == null)
				continue;
			search.showSnackAll3();
		}
	}

	public void scannerClose() {
		s.close();
	}
	//2번
	public void sf(String s) {
		System.out.println(s);
	}
	//5번
	public String addr() {
		System.out.print("편의점 주소: ");
		return s.next();
	}
	//6번
	public String snackName() {
		System.out.print("상품 이름: ");
		return s.next();
	}
}
