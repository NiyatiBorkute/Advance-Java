package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Dept;
import com.demo.service.DeptService;
import com.demo.service.DeptServiceImpl;

public class TestDeptManagement {


public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int choice=0;
	DeptService dservice=new DeptServiceImpl();
	do {
		System.out.println("1. add new dept\n2. delete dept\n3. modify dept");
		System.out.println("4.find by deptno\n5. display all\n6. display in sorted order\n7. exit");
		System.out.println("choice :");
		choice=sc.nextInt();
		switch(choice) {
		case 1->{
			boolean status=dservice.addNewDept();
			if(status) {
				System.out.println("dept addedd successfully");
			}else {
				System.out.println("Not added");
			}
		}
		case 2->{
			System.out.println("enter deptno");
			int deptno=sc.nextInt();
			boolean status=dservice.deleteByDeptno(deptno);
			if(status) {
				System.out.println("dept deleted successfully");
			}else {
				System.out.println("Not deleted");
			}
		}
		case 3->{
			System.out.println("enter deptno");
			int deptno=sc.nextInt();
			System.out.println("enter loc");
			String loc=sc.next();
			System.out.println("enter pwd");
			String pwd=sc.next();
			boolean status=dservice.modifyByDeptno(deptno,loc,pwd);
			if(status) {
				System.out.println("dept updated successfully");
			}else {
				System.out.println("Not updated");
			}
		}
		case 4->{
			System.out.println("enter deptno");
			int deptno=sc.nextInt();
			Dept d=dservice.getByDeptno(deptno);
			if(d==null) {
				System.out.println("not found");
			}else {
				System.out.println(d);
			}
		}
		case 5->{
			List<Dept> plst=dservice.getAllDept();
			plst.forEach(System.out::println);
		}
		case 6->{
			List<Dept> plst=dservice.sortByPwd();
			plst.forEach(System.out::println);
		}
		case 7->{
			System.out.println("Thank you for visiting .....");
			sc.close();
		}
		}
	}while(choice!=7);


	}

}
