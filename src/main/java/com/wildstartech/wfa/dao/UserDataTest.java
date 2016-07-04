package com.wildstartech.wfa.dao;

import org.testng.annotations.Test;

public class UserDataTest {
	@Test
	public void getAdminUser() {
		String userName;
		String password;
		UserData userData=null;
		
		userData=UserData.getInstance();
		
		userName=userData.getAdminUserName();
		password=userData.getAdminPassword();
	
		assert userName != null;
		assert password != null;
	}
}