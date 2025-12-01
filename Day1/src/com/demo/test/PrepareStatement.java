package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatement {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.117:3306/dac43?useSSL=false";
			conn=DriverManager.getConnection(url,"dac43","welcome");
			PreparedStatement pst=conn.prepareStatement("select * from softdrink");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt("ID"));
				System.out.println("NAME: "+rs.getString("NAME"));
				System.out.println("RATE: "+rs.getInt("RATE"));
				System.out.println("--------------------------------------------------");
				
			}
			PreparedStatement pst1=conn.prepareStatement("insert into softdrink values(?,?,?)");
			int ID=6;
			String NAME="sprite";
			int RATE=34;
			pst1.setInt(1,ID);
			pst1.setString(2,NAME);
			pst1.setInt(3,RATE);
			
			int n=pst1.executeUpdate();
			if(n>0) {
				System.out.println("insertion done");
			}
			else {
				System.out.println("error");
			}
			
		} catch (SQLException e) {
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
