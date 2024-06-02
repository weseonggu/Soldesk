package com.we.mar201.product;

import java.util.HashMap;
import java.util.List;

public interface ProductMapper {
	public abstract List<Product> getProduct(HashMap<String, String> p);
	public abstract int allProducts();
}
