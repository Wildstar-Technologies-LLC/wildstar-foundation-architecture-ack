package com.wildstartech.wfa.dao.user;

import java.util.List;

import org.testng.annotations.Test;

import com.wildstartech.wfa.dao.UserData;
import com.wildstartech.wfa.dao.WildDAOTest;
import com.wildstartech.wfa.user.PasswordTooLongException;
import com.wildstartech.wfa.user.TestCaseUser1;
import com.wildstartech.wfa.user.User;

public class UserDAOTest extends WildDAOTest {
   @Test
   public void testGetDAO() {      
      UserDAO dao=null;
      UserDAOFactory factory=null;
      
      factory=new UserDAOFactory();
      dao=factory.getDAO();
      assert dao != null;
   }
   
   @Test(dependsOnMethods={"testGetDAO"})
   public void testCreate() {
      User user=null;
      UserDAO dao=null;
      UserDAOFactory factory=null;
      
      factory=new UserDAOFactory();
      dao=factory.getDAO();
      user=dao.create();
      assert user != null;
      assert user instanceof User;
      assert user instanceof PersistentUser;
   }
   
   @Test(dependsOnMethods={"testCreate"})
   public void testSave() {
      PersistentUser pUser=null;
      String testStr=null;
      User user=null;
      UserContext ctx=null;
      UserData userData=null;
      UserDAO dao=null;
      UserDAOFactory factory=null;
      
      userData=UserData.getInstance();
      ctx=UserContextDAOFactory.authenticate(
            userData.getAdminUserName(),
            userData.getAdminPassword());
      factory=new UserDAOFactory();
      dao=factory.getDAO();
      user=new TestCaseUser1();
      
      pUser=dao.save(user, ctx);
      
      assert pUser != null;
      testStr=pUser.getName();
      assert testStr != null;
      assert testStr.equalsIgnoreCase(user.getName());
      
      // Test password
      ctx=UserContextDAOFactory.authenticate(
            user.getName(),
            user.getPassword());
      
      assert ctx.isAuthenticated() == true;      
   }
   
   @Test(dependsOnMethods={"testSave"})
   public void testMultipleSave() {
      int countOfPersistentUsers=0;
      List<PersistentUser> users=null;
      PersistentUser pUser=null;
      String testStr=null;
      User user=null;
      UserContext ctx=null;
      UserData userData=null;
      UserDAO dao=null;
      UserDAOFactory factory=null;
      
      userData=UserData.getInstance();
      ctx=UserContextDAOFactory.authenticate(
            userData.getAdminUserName(),
            userData.getAdminPassword());
      factory=new UserDAOFactory();
      dao=factory.getDAO();
      user=new TestCaseUser1();
      
      pUser=dao.save(user, ctx);
      users=dao.findAll(ctx);
      countOfPersistentUsers=users.size();
      
      try {
         pUser.setPassword("SomethingElse");
      } catch (PasswordTooLongException ex) {
         // no-op
      }
      pUser=dao.save(pUser, ctx);
      
      users=dao.findAll(ctx);
      assert users.size() == countOfPersistentUsers;
   }
}