package com.winter.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/spring", "root", "root");
			
		}
		catch(Exception e) {
			
			System.out.println("inside catch");
			e.printStackTrace();
		}
		
		return conn;
	}

}
