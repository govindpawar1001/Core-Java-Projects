package com.linkcode.model;

public class Admin {
	private final static String username="admin";
	private final static String password="admin";
	
	public Admin(String username,String password) {
		super();
		username = username;
		password = password;
	}
	

	
	public static boolean authenticate(String user,String pass) {
		if(user.equals(username)&&(pass.equals(password))){
			System.out.println("Login Successful");
			
			return true;
		}else {
			return false ;
		}
	}

}
