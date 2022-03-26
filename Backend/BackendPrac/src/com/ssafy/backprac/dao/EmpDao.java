package com.ssafy.backprac.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.backprac.dto.Emp;

public interface EmpDao {
	public List<Emp> selectEmp();
	public Emp selectEmpById(@Param("empno")String empno, @Param("ename")String ename);
}
