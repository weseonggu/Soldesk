package com.we.mar141.data;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataDAO {
	@Autowired
	private SqlSession ss;
	
	public void getDatas(HttpServletRequest req) {
		try {
			List<DataInfo> datas =ss.getMapper(DataMapper.class).getData();
			System.out.println(datas.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DataInfos getJSON(HttpServletRequest req) {
		return new DataInfos(ss.getMapper(DataMapper.class).getData());
	}
}
