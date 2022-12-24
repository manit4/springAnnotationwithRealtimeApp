package com.winter.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.winter.config.MyConfig;
import com.winter.repository.UserRepository;
import com.winter.service.UserService;

public class MainController {


	public static void main(String[] args) {


		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		
		UserService service = context.getBean("userService", UserService.class);

		Scanner sc = new Scanner(System.in);

		System.out.println("Press 1 for Login, 2 for Registration and 0 for Logout");

		int value = sc.nextInt();

		switch(value) {

		case 1: 
			
			System.out.println("Enter your Username!!");
			
			String uname = sc.next();
			
			System.out.println("Enter your Password!!");
			String pwd = sc.next();
			
			String loginStatus = service.validate(uname, pwd);
			
			if(loginStatus.equals("Success")) {
				System.out.println("Welcome User...");
			}
			else {
				System.out.println("Wrong Credentials, please try again!!");
			}

			break;

		case 2:

			System.out.println("Enter your Username!!");
			String username = sc.next();

			System.out.println("Enter your Password!!");
			String password = sc.next();

			System.out.println("Enter your Name!!");
			String name = sc.next();

			//UserService service = new UserService();
			
			

			service.saveUser(username, password, name);

			break;

		case 0:

			System.out.println("Goodbye and hoping to see you again...");
		}


	}

}
