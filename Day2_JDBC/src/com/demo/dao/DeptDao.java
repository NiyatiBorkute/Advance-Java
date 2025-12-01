package com.demo.dao;

import java.util.List;

import com.demo.beans.Dept;

public interface DeptDao {

	boolean save(Dept p);

	boolean removeByDeptno(int deptno);

	boolean updateByDeptno(int deptno, String loc, String pwd);

	Dept findById(int deptno);

	List<Dept> findAllDept();

	List<Dept> arrangeByPwd();

}
