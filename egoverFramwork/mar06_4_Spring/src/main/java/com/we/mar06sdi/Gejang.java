package com.we.mar06sdi;

import org.springframework.beans.factory.annotation.Autowired;

// 생성자도 setter도 없음
// 1) 세상의 모든 게장은 beans3.xml에 있는 그사람이 만든다
// 2) beans3.xml에는 하나의 사람만 등록되어있음
// 3) aac방식 :  딱히 사용하지 않아도 삶은 생성 될것
// Spring singletun
public class Gejang {
	@Autowired
	private Human producer;

	public Human getProducer() {
		return producer;
	}
}
