package com.we.main;

import com.we.needclass.Product;

public class HomeController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConsoleScreen cs = new ConsoleScreen();
		int num = 0;

		while (true) {

			num = cs.whatDo();

			if (num == 10) {
				break;
			} else if (num == 1) {// 편의점 등록

				String s = DAO.getCdho().insertCVS(cs.showRegCVSMenu());
				cs.sf(s);
			} else if (num == 2) {// 상품 등록
				Product p = cs.showProduct(DAO.getCdho().cvsNum());
				String s = DAO.getCdho().insertProduct(p);
				cs.sf(s);
			} else if (num == 3) {// 전체 조회
				int pageNum = cs.getPage(DAO.getCdho().getAllPage());
				cs.showSearch(DAO.getCdho().selectAll(pageNum));
			} else if (num == 4) {// 상품 조회
				int pageNum = cs.getPage(DAO.getCdho().getAllPage());
				cs.showSearch2(DAO.getCdho().selectSnack(pageNum));
			} else if (num == 5) {//
				String addr = cs.addr();
				int ap = DAO.getCdho().searchCSVCount(addr);
				cs.showSearch3(DAO.getCdho().cvsAddr(cs.getPage(ap), addr));
			} else if (num == 6) {
				String sName = cs.snackName();
				int a = DAO.getCdho().searchProduct(sName);
				cs.showSearch4(DAO.getCdho().productNameLocation(a, sName));
			}

		}

		cs.scannerClose();
	}

}
