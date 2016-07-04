package com.wildstartech.wfa.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wildstartech.wfa.MockObject;
import com.wildstartech.wfa.group.Group;

public class MockUser extends MockObject implements User {
	private List<Group> groups=null;
	private String userName="";
	private String password="";
	
	/**
	 * Default, no-argument constructor.
	 */
	public MockUser() {
		this.userName="";
		this.password="";
		this.groups=new ArrayList<Group>();
	}
	
	/**
	 * Constructor taking a username and password as parameters.
	 */
	public MockUser(String userName, String password) {
		this.userName=userName;
		this.password=password;
		this.groups=new ArrayList<Group>();
	}
	
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addGroup(Group group) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeGroup(Group group) {
		if (this.groups.contains(group)) {
			this.groups.remove(group);
		} // END if (this.groups.contains(group))
	}

	@Override
	public List<Group> getGroups() {
		return Collections.unmodifiableList(this.groups);
	}

	@Override
	public String getName() {
		return this.userName;
	}

	@Override
	public void setName(String name) throws UserNameTooLongException {
		this.userName=defaultValue(name);
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public void setPassword(String name) throws PasswordTooLongException {
		this.password=defaultValue(name);
	}
}