package com.winter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.winter.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public void saveUser(String username, String password, String name) {
		
		
		repository.addUser(username, password, name);
	}
	
	public String validate(String username, String password) {
		
		String logonStatus = repository.findUser(username, password);
		
		return logonStatus;
	}

}
