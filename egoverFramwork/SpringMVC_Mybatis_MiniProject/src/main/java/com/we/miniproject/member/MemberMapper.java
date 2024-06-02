package com.we.miniproject.member;

public interface MemberMapper {
	// 가입
	public abstract int join(Member m);
	//로그인
	public abstract Member getMemberByID(Member m);
	
	public abstract int bye(Member m);
	
	public abstract int infoChage(Member m);
}
