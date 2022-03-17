package com.ssafy.test;

import java.util.Arrays;
import java.util.List;

import com.ssafy.common.db.MyAppSqlConfig;
import com.ssafy.dao.BoardDao;
import com.ssafy.dao.TestDao;
import com.ssafy.dao.TestDaoImpl;
import com.ssafy.dto.Board;
import com.ssafy.dto.Member;

public class Test1 {
	
	
	public static void main(String[] args) {
		try {
			BoardDao dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDao.class);
			List<Board> list = dao.selectBoard();
			for (Board b : list) {
				System.out.println(b.getNo()+","+b.getTitle());
			}
			//TestDao dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(TestDao.class);
			//TestDao dao = new TestDaoImpl();
			/*
			Member member = new Member();
			member.setId("member-4");
			member.setEmail("부울경@ssafy.com");
			dao.updateMember(member);
			System.out.println("회원정보가 수정되었습니다.");
			
	
			/*
			dao.deleteMember("member-5");
			System.out.println("삭제되었습니다");
			
			/*
			Member member = new Member();
			member.setId("member-5");
			member.setName("허경영");
			member.setEmail("허경영@ssafy.com");
			member.setAddr("하늘궁");
			dao.insertMember(member);
			System.out.println("회원이 추가되었습니다.");
			/*
			Member member = new Member();
			member.setId("member-3");
			member.setEmail("daejeon@ssafy.com");
			System.out.println(dao.selecMemberByInfo(member));
			/*
			Member m = dao.selectMemberById("member-3");
			/*
			List<Member> list = dao.selectMember();
			for(Member m : list) {
				System.out.println(m.getId()+","+m.getName() +","+ m.getJoinDate());
			}
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










