package com.demo.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementDemo{

	public static void main(String[] args) {
		Connection conn=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.117:3306/dac43?useSSL=false"; 
			conn=DriverManager.getConnection(url,"dac43","welcome");
			CallableStatement cst=conn.prepareCall("call pro4(?,?)");
			

			cst.setInt(1, 10);
			
			cst.registerOutParameter(2, java.sql.Types.INTEGER);
			cst.execute();
			int cnt=cst.getInt(2);
			System.out.println("count : "+cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch ( SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
