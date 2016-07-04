package com.wildstartech.wfa.dao;

import java.util.logging.Logger;

public class Credentials {
	private static final String _CLASS=Credentials.class.getName();
	private static final Logger logger=Logger.getLogger(_CLASS);
	
	private String userName="";
	private String password="";
	
	/**
	 * Builder method to return an instance of the class.
	 * @param userName
	 * @param password
	 * @return
	 */
	public static Credentials build(String userName,String password) {
		logger.entering(_CLASS, "build(String,String)",
				new Object[] {userName,password});
		
		Credentials credentials=null;
		credentials=new Credentials(userName,password);
		
		logger.exiting(_CLASS, "build(String,String)",credentials);
		return credentials;
	}
	/**
	 * Default, no-argument constructor.
	 */
	public Credentials() {
		this.userName="";
		this.password="";
	}
	
	/**
	 * Initializes an instance of the class using the specified values.
	 */
	public Credentials(String userName, String password) {
		this.userName=userName;
		this.password=password;
	}
	
	//***** password
	public String getPassword() {
		logger.entering(_CLASS, "getPassword()");
		logger.exiting(_CLASS, "getPassword()",this.password);
		return this.password;
	}
	public void setPassword(String password) {
		logger.entering(_CLASS, "setPassword(String)",password);
		this.password=password;
		logger.exiting(_CLASS, "setPassword(String)");
	}
	//***** userName
	public String getUserName() {
		logger.entering(_CLASS, "getUserName()");
		logger.exiting(_CLASS, "getUserName()",this.userName);
		return this.userName;
	}
	public void setUserName(String userName) {
		logger.entering(_CLASS, "setUserName(String)",userName);
		this.userName=userName;
		logger.exiting(_CLASS, "setUserName(String)");
	}
}