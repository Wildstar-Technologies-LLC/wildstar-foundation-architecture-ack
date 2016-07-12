/*
 * Copyright (c) 2001 - 2016 Wildstar Technologies, LLC.
 *
 * This file is part of the Wildstar Foundation Architecture ACK.
 *
 * Wildstar Foundation Architecture Application Compatibility Kit (WFA-ACK) 
 * is free software: you can redistribute it and/or modify it under the 
 * terms of the GNU General Public License as published by the Free  
 * Software Foundation, either version 3 of the License, or (at your  
 * option) any later version.
 *
 * WFA-ACK is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License 
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * WFA-ACK.  If not, see  <http://www.gnu.org/licenses/>.
 * 
 * Linking this library statically or dynamically with other modules is making a
 * combined work based on this library. Thus, the terms and conditions of the 
 * GNU General Public License cover the whole combination.
 * 
 * As a special exception, the copyright holders of this library give you 
 * permission to link this library with independent modules to produce an 
 * executable, regardless of the license terms of these independent modules, 
 * and to copy and distribute the resulting executable under terms of your 
 * choice, provided that you also meet, for each linked independent module, the
 * terms and conditions of the license of that module. An independent module is
 * a module which is not derived from or based on this library. If you modify 
 * this library, you may extend this exception to your version of the library, 
 * but you are not obliged to do so. If you do not wish to do so, delete this 
 * exception statement from your version.
 * 
 * If you need additional information or have any questions, please contact:
 *
 *      Wildstar Technologies, LLC.
 *      63 The Greenway Loop
 *      Inlet Beach, FL 32461
 *      USA
 *
 *      derek.berube@wildstartech.com
 *      www.wildstartech.com
 */
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