package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatement {
	
		public static void main(String[] args) {
			Connection conn = null;
			
			try {
				//step1
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				//step2
				String url="jdbc:mysql://192.168.10.117:3306/dac43?useSSL=false";
				conn = DriverManager.getConnection(url,"dac7","welcome");
				if(conn!=null) {
					System.out.println("Connection done.");
				}
				else {
					System.out.println("Connection not done.");
				}
				
				//step 3
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select * from emp");
				while(rs.next()) {
					
					System.out.println("empno:"+rs.getInt(1));
					System.out.println("empname:"+rs.getString(2));
					System.out.println("gender:"+rs.getString(3));
					System.out.println("job:"+rs.getString(4));
					
					System.out.println("-----------------------------");
					
				}
				
				int empno=4823;
				String ename="Ram";
				char gender='M';
				String job="Compliance officers ";
				int deptno=10;
				
				String query="insert into emp (EMPNO,ENAME,GENDER,JOB,DEPTNO) values("+empno+",'"+ename+"','"+gender+"','"+job+"',"+deptno+")";
				System.out.println(query);
				int n=st.executeUpdate(query);
				if(n>0) {
					System.out.println("insertion done");
				}else {
					System.out.println("error");
				}
				
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
