package com.winter.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

import com.mysql.cj.protocol.Resultset;
import com.winter.db.DBConnection;

@Component
public class UserRepository {
	
	public UserRepository() {
		System.out.println("inside UserRepository...");
	}
	
	public void addUser(String username, String password, String name) {
		
		try {
			
			DBConnection connection = new DBConnection();
			
			Connection conn = connection.getConnection();
			
			PreparedStatement statement = conn.prepareStatement("insert into user values(?, ?, ?)");
			
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, name);
			
			statement.executeUpdate();
			
		}
		catch(Exception e ) {
			
		}	
	}
	
	public String findUser(String username, String password) {
		
		String loginStatus = "Failed";
		
		try {
			
			DBConnection connection = new DBConnection();
			
			Connection conn = connection.getConnection();
			
			PreparedStatement preparedStatement = conn.prepareStatement("select * from user where username = ? and password = ?");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				loginStatus = "Success";
				
			}
		}
		catch(Exception e ) {
			
		}
		return loginStatus;
		
	}

}
