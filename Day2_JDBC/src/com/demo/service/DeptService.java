package com.demo.service;

import java.util.List;

import com.demo.beans.Dept;

public interface DeptService {

	boolean addNewDept();

	boolean deleteByDeptno(int deptno);

	boolean modifyByDeptno(int deptno, String loc, String pwd);

	Dept getByDeptno(int deptno);

	List<Dept> getAllDept();

	List<Dept> sortByPwd();

}
