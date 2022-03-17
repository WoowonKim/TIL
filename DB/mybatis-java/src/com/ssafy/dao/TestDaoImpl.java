package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.common.db.MyAppSqlConfig;
import com.ssafy.dto.Member;

public class TestDaoImpl implements TestDao {
	private final static String NS = "com.ssafy.dao.TestDao";
	private SqlSession session;
	public TestDaoImpl() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public List<Member> selectMember() {
		return session.selectList(NS+"selectMember");
	}
	
	public Member selectMemberById(String id) {
		return session.selectOne(NS+"selectMemberById",id);
	}
	
	public String selecMemberByInfo(Member member) {
		return session.selectOne(NS+"selectMemberByInfo",member);
	}
	
	public void insertMember(Member member) {
		session.insert(NS+"insertMember",member);
	}
	public void deleteMember(String id) {
		session.delete(NS+"deleteMember",id);
	}
	
	public void updateMember(Member member) {
		session.update(NS+"updateMember",member);
	}
}








