package com.we.miniproject.sns;

import java.util.HashMap;
import java.util.List;

import com.we.miniproject.member.Member;

public interface SnsMapper {
	public abstract int writePost(SnsPost sp);
	public abstract int getPostCount();
	public abstract List<SnsPost> getSnsPost(HashMap<String, String> condition);
	public abstract int searchPost(HashMap<String, String> condition);
	public abstract int deletePsot(SnsPost sp);
	public abstract int withdrawMember(Member m);
	public abstract int snsCommentWriter(SnsComment sc);
	public abstract List<SnsComment> getSnsComments(HashMap<String, String> condition);
	
}
