/*
 * Copyright (c) 2013 - 2016 Wildstar Technologies, LLC.
 *
 * This file is part of Wildstar Foundation Architecture.
 *
 * Wildstar Foundation Architecture is free software: you can redistribute it
 * and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * Wildstar Foundation Architecture is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Wildstar Foundation Architecture.  If not, see 
 * <http://www.gnu.org/licenses/>.
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
 *      Panama City Beach, FL 32413
 *      USA
 *
 *      derek.berube@wildstartech.com
 *      www.wildstartech.com
 */
package com.wildstartech.wfa.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.wildstartech.wfa.dao.UserContextDAO;

public class UserData {
	private static String _CLASS = UserData.class.getName();
	private static Logger logger = Logger.getLogger(_CLASS);
	private static String _USERKEY="com.wildstartech.wfa.dao.";
	
	private static UserData data = new UserData();
	
	private Map<String, Credentials> users = null;
	private Credentials adminCredentials = null;

	/**
	 * Default, no-argument constructor.
	 */
	private UserData() {
		initAdminUser();
		initUsers();
	}

	/**
	 * Returns an instance of the UserData object.
	 * @return
	 */
	public static UserData getInstance() {
		return UserData.data;		
	}
	
	/**
	 * Initialization routine.
	 */
	private void initAdminUser() {
		ClassLoader cl = null;
		Credentials credentials=null;
		InputStream in = null;
		Properties props = null;

		cl = UserData.class.getClassLoader();
		in = cl.getResourceAsStream("wild-dao-admin.properties");
		if (in != null) {
			props = new Properties();
			try {
				props.load(in);
				credentials=new Credentials();
				credentials.setUserName(
						props.getProperty(UserContextDAO.PROPKEY_ADMIN_USER));
				credentials.setPassword(
						props.getProperty(
								UserContextDAO.PROPKEY_ADMIN_PASSWORD));
			} catch (IOException ex) {
				ex.printStackTrace();
			} // END try/catch
		} // END if (in != null)
	}
	
	/**
	 * Initialize the list of users.
	 */
	private void initUsers() {
		logger.entering(_CLASS, "initUsers()");
		ClassLoader cl = null;
		Credentials credentials=null;
		InputStream in = null;
		Properties props = null;
		String user=null;
		String userList=null;
		String userName=null;
		String userPassword=null;
		StringBuilder userKey=null;
		StringBuilder userPasswordKey=null;
		StringTokenizer tokenizer=null;

		cl = UserData.class.getClassLoader();
		in=cl.getResourceAsStream("users.properties");
		this.users=new TreeMap<String,Credentials>();
		
		if (in != null) {
			props=new Properties();
			try {
				props.load(in);
				userList=props.getProperty("com.wildstartech.wfa.dao.users");
				tokenizer=new StringTokenizer(userList,",");
				while(tokenizer.hasMoreTokens()) {
					user=tokenizer.nextToken();
					// Let's build the keys.
					userKey=new StringBuilder(128);
					userKey.append(_USERKEY);
					userKey.append(user).append(".username");
					userPasswordKey=new StringBuilder(128);
					userPasswordKey.append(_USERKEY);
					userPasswordKey.append(user).append(".password");
					userName=props.getProperty(userKey.toString());
					userPassword=props.getProperty(userPasswordKey.toString());
					credentials=Credentials.build(userName, userPassword);
					this.users.put(user, credentials);
					user="";
					userName="";
					userPassword="";
				} // END while(tokenizer.hasMoreTokens())
			} catch (IOException ex) {
				logger.log(Level.SEVERE, "Error loading users.properties", ex);
			} // END try/catch
		}
		logger.exiting(_CLASS, "initUsers()");
	}
	
	/**
	 * Return the administrative user name for the persistence framework.
	 * 
	 * @return A string value that represents the username for the
	 *         administrative user.
	 */
	public String getAdminUserName() {
		logger.entering(_CLASS, "getAdminUserName()");
		logger.exiting(_CLASS, "getAdminUserName()", 
				UserData.data.adminCredentials.getUserName());
		return UserData.data.adminCredentials.getUserName();
	}

	/**
	 * Return the administrative password for the persistence framework.
	 * 
	 * @return A string value that represents the password for the
	 *         administrative user.
	 */
	public String getAdminPassword() {
		logger.entering(_CLASS, "getAdminPassword()");
		logger.exiting(_CLASS, "getAdminPassword()", 
				UserData.data.adminCredentials.getPassword());
		return UserData.data.adminCredentials.getPassword();
	}

	/**
	 * Returns the name of the specified user.
	 */
	public String getUserName(String userKey) {
		logger.entering(_CLASS, "getUserName(String)",userKey);
		Credentials credentials=null;
		String userName=null;
		
		credentials=UserData.data.users.get(userKey);
		if (credentials != null) {
			userName=credentials.getUserName();
		} else {
			userName="";
		} // END if (credentials != null)
		
		logger.exiting(_CLASS, "getUserName(String)",userName);
		return userName;
	}
	
	/**
	 * Returns the password for the specified user.
	 */
	public String getUserPassword(String userKey) {
		logger.entering(_CLASS, "getUserPassword(String)",userKey);
		
		Credentials credentials=null;
		String password="";
		
		credentials=UserData.data.users.get(userKey);
		if (credentials != null) {
			password=credentials.getPassword();
		} else {
			password="";
		} // END if (credentials != null)
		
		logger.exiting(_CLASS, "getUserPassword(String)",password);
		return password;
	}	
}