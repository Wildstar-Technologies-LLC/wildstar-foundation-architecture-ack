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

import org.testng.annotations.Test;

import java.util.Date;
import java.util.Set;

import org.testng.AssertJUnit;

import com.wildstartech.wfa.dao.user.PersistentUser;
import com.wildstartech.wfa.dao.user.UserContext;
import com.wildstartech.wfa.dao.user.UserContextDAO;
import com.wildstartech.wfa.dao.user.UserContextDAOFactory;
import com.wildstartech.wfa.dao.user.UserDAO;
import com.wildstartech.wfa.dao.user.UserDAOFactory;
import com.wildstartech.wfa.user.PasswordTooLongException;
import com.wildstartech.wfa.user.User;
import com.wildstartech.wfa.user.UserNameTooLongException;

public class UserDAOTest {
  
  @Test
  public void createUser() {
    boolean authenticated=false;
    long currentTime=0;
    UserContext ctx=null;
    UserContextDAO ctxDAO=null;
    UserContextDAOFactory ctxFactory=null;
    User user=null;
    PersistentUser pUser=null;
    UserData userData=null;
    UserDAO dao=null;
    UserDAOFactory factory=null;
    
    // Let's get some credentials
    userData=UserData.getInstance();
    ctxFactory=new UserContextDAOFactory();
    ctxDAO=ctxFactory.getDAO();
    ctx=ctxDAO.create();
    ctx.setUserName(userData.getAdminUserName());
    ctx.setPassword(userData.getAdminPassword());
    // Authenticate
    authenticated=ctx.authenticate();
    AssertJUnit.assertTrue(authenticated);
    
    factory=new UserDAOFactory();
    AssertJUnit.assertNotNull(factory);
    dao=factory.getDAO();
    assert dao != null;
    user=dao.create();
    assert user != null;
    assert user instanceof PersistentUser;
    
    try {
      user.setName("derek.berube@wildstartech.com");
      user.setPassword("Nerfherder");
    } catch (UserNameTooLongException ex) {
      // The name was too long.
      ex.printStackTrace();
    } catch (PasswordTooLongException ex) {
      // The password was too long
      ex.printStackTrace();
    }
    
    pUser=dao.save(user,ctx);
    currentTime=new Date().getTime();
    assert pUser.getIdentifier() != null;
    assert pUser.getName().equals(user.getName());
    assert pUser.getPassword().equals(user.getPassword());
    assert pUser.getCreatedBy().equals(userData.getAdminUserName());
    assert (pUser.getDateCreated().getTime() - currentTime) < 1000;
    assert pUser.getModifiedBy().equals(userData.getAdminUserName());
    assert (pUser.getDateModified().getTime() - currentTime) < 1000;
  }
  

  /**
   * Creates the users specified in UserData.
   */
  @Test
  public void createTestUsers() {
	  Set<String> userNames=null;
	  String adminUserName="";
	  String adminPassword="";
	  String userName="";
	  String userPassword="";
	  User user=null;
	  UserContext ctx=null;
	  UserData userData=null;
	  UserDAO dao=null;
	  UserDAOFactory factory=null;
	  
	  userData=UserData.getInstance();
	  userNames=userData.getUserNames();
	  adminUserName=userData.getAdminUserName();
	  adminPassword=userData.getAdminPassword();
	  ctx=UserContextDAOFactory.authenticate(adminUserName,adminPassword);
	  assert ctx != null;
	  assert ctx.isAuthenticated() == true;
	  factory=new UserDAOFactory();
	  dao=factory.getDAO();
	  assert dao != null;
	  for (String userKey: userNames) {
		  userName=userData.getUserName(userKey);
		  userPassword=userData.getUserPassword(userKey);
		  user=dao.create();
		  try {
			user.setName(userName);
			user.setPassword(userPassword);
			user=dao.save(user, ctx);
			assert user != null;
		} catch (UserNameTooLongException ex) {
			ex.printStackTrace(System.err);
		} catch (PasswordTooLongException pwdEx) {
			pwdEx.printStackTrace(System.err);
		} // END try/catch		  
	  } // END for (String userKey: userNames)
  }
}
