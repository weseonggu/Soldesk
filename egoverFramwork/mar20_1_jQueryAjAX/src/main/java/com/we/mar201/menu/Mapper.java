package com.we.mar201.menu;

import java.util.List;

public interface Mapper {
	public abstract List<Menu> getData();
	public abstract int reg(Menu m);
	public abstract List<Menu> search(Menu m);
}
