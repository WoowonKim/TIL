package com.ssafy.dao;

import java.util.List;

import com.ssafy.dto.Member;

public interface TestDao {
	List<Member> selectMember();
	Member selectMemberById(String id);
	String selecMemberByInfo(Member member);
	void insertMember(Member member);
	void deleteMember(String id);
	void updateMember(Member member);
}