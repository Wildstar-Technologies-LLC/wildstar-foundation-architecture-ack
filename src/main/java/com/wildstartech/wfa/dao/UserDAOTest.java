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

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import com.wildstartech.wfa.dao.PersistentUser;
import com.wildstartech.wfa.dao.UserContext;
import com.wildstartech.wfa.dao.UserContextDAO;
import com.wildstartech.wfa.dao.UserContextDAOFactory;
import com.wildstartech.wfa.dao.UserDAO;
import com.wildstartech.wfa.dao.UserDAOFactory;
import com.wildstartech.wfa.user.PasswordTooLongException;
import com.wildstartech.wfa.user.UserNameTooLongException;

public class UserDAOTest {
  
  @Test
  public void createUser() {
    boolean authenticated=false;
    UserContext ctx=null;
    UserContextDAO ctxDAO=null;
    UserContextDAOFactory ctxFactory=null;
    PersistentUser user=null;
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
    
    user=dao.save(user,ctx);
    
    System.out.println(user.getIdentifier());
    System.out.println(user.getName());
    System.out.println(user.getPassword());
    System.out.println(user.getCreatedBy());
    System.out.println(user.getDateCreated());
    System.out.println(user.getModifiedBy());
    System.out.println(user.getDateModified());
    
  }
}
