package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		//드라이버 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //driver에 있는 패키지 포함 클래스 이름
			//연결하기
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
			String sql = "select *"
					+ "  from emp"
					+ "  where deptno = 10";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("ename"));
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// sql 작성
	}
}
