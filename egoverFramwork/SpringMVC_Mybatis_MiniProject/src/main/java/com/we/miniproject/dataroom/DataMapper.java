package com.we.miniproject.dataroom;

import java.util.HashMap;
import java.util.List;

public interface DataMapper {
	public abstract int upload(DataInfo di);
	public abstract List<DataInfo> getData(HashMap<String, String> con);
	public abstract int getDataCount();
}
