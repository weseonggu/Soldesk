package com.we.mar201.product;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAO {
	@Autowired
	private SqlSession ss;
	
	public Products getProduct(int page) {
		int productCount = ss.getMapper(ProductMapper.class).allProducts();
		int  pageCount = (int)Math.ceil(productCount/3.0);
		if(page<=pageCount) {			
			int end = page*3;
			int start = end-2;
			HashMap<String, String> p = new HashMap<String, String>();
			p.put("start", start+"");
			p.put("end", end+"");
			return new Products(ss.getMapper(ProductMapper.class).getProduct(p));			
		}else {
			return null;
		}

	}
}
