package com.ssafy.backend.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ssafy.backend.dto.User;

public class userDAO {
	
	// sql 세션 생성을 해주는 세션 팩토리
	private SqlSessionFactory sqlSessionFactory;

	// 세션 팩토리 객채 생성하고 그 결과 리턴
	private boolean connect() {
		boolean result = true;
		try {
			// mybatis 환경설정 로드
			String resource = "mybatis_config.xml";

			// Reader로 환경설정 파일 읽어오기
			Reader reader = Resources.getResourceAsReader(resource);

			// 세션 팩토리 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}

		return result;
	}

	// 등록된 전체 사용자 조회
	public List<User> selectAllUsers() {
		List<User> list = new ArrayList<User>();

		if (connect()) {
			SqlSession session = sqlSessionFactory.openSession();
			try {
				// mapper 에 정의된 사용자 전체를 찾는 쿼리문 매핑
				list = session.selectList("userMapper.allUsers");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			System.out.println("연결 실패");
		}

		return list;
	}
	
	// id로 사용자 검색
	public User selectUserById(String id) {
		User user = new User();
		
		if(connect()) {
			SqlSession session = sqlSessionFactory.openSession();
			try {
				// mapper 에 정의된 사용자를 id로 찾는 쿼리문 매핑
				user = session.selectOne("userMapper.selectUserById", id);
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			System.out.println("연결 실패");
		}
		
		return user;
	}

	// 사용자 등록
	public boolean insertUser(User user) {
		boolean result = false;
		if (connect()) {
			SqlSession session = sqlSessionFactory.openSession();
			try {
				// mapper 에 정의된 사용자를 삽입하는 쿼리문 매핑
				int r = session.insert("userMapper.insertUser", user);
				// r이 0보다 크면 삽입에 성공
				if (r > 0) {
					result = true;
					session.commit();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			System.out.println("연결 실패");
		}
		return result;
	}
	
	// 사용자 수정
	public boolean updateUser(User user) {
		boolean result = false;
		if (connect()) {
			SqlSession session = sqlSessionFactory.openSession();
			try {
				// mapper 에 정의된 사용자를 수정하는 쿼리문 매핑
				int r = session.update("userMapper.updateUser", user);
				// r이 0보다 크면 수정에 성공
				if (r > 0) {
					result = true;
					session.commit();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			System.out.println("연결 실패");
		}
		return result;
	}
	
	// 사용자 삭제
	public boolean deleteUser(String id) {
		boolean result = false;
		if (connect()) {
			SqlSession session = sqlSessionFactory.openSession();
			try {
				// mapper 에 정의된 사용자를 삭제하는 쿼리문 매핑
				int r = session.delete("userMapper.deleteUser", id);
				// r이 0보다 크면 삭제에 성공
				if (r > 0) {
					result = true;
					session.commit();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			System.out.println("연결 실패");
		}
		return result;
	}
	
	// 사용자 개수 조회
	public int userCount() {
		int res = 0;
		
		if(connect()) {
			SqlSession session = sqlSessionFactory.openSession();
			try {
				// mapper 에 정의된 사용자 개수를 조회하는 쿼리문 매핑
				res = session.selectOne("userMapper.userCount");
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			System.out.println("연결 실패");
		}
		
		return res;
	}

}
