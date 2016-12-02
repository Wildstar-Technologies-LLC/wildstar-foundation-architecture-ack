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
package com.wildstartech.wfa.dao.user;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.Test;

import com.wildstartech.wfa.dao.UserData;
import com.wildstartech.wfa.dao.WildDAOTest;
import com.wildstartech.wfa.user.PasswordResetRequest;
import com.wildstartech.wfa.user.TestCasePasswordResetRequest1;
import com.wildstartech.wfa.user.UserNameTooLongException;

public class PasswordResetRequestDAOTest extends WildDAOTest {
   private static final String _CLASS=PasswordResetRequestDAOTest.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   @Test
   public void getDAO() {
      PasswordResetRequestDAO dao=null;
      PasswordResetRequestDAOFactory factory=null;
      
      factory=new PasswordResetRequestDAOFactory();
      dao=factory.getDAO();
      assert dao != null;
      assert dao instanceof PasswordResetRequestDAO;      
   }
   
   @Test(dependsOnMethods={"getDAO"})
   public void create() {
      PasswordResetRequest request=null;
      PasswordResetRequestDAO dao=null;
      PasswordResetRequestDAOFactory factory=null;
      
      factory=new PasswordResetRequestDAOFactory();
      dao=factory.getDAO();
      request=dao.create();
      
      assert request != null;
      assert request instanceof PasswordResetRequest;
      assert request instanceof PersistentPasswordResetRequest;
   }
   
   @Test(dependsOnMethods={"create"})
   public void testSave() {
      PasswordResetRequest newRequest=null;
      PasswordResetRequest testCase=null;
      PasswordResetRequestDAO dao=null;
      PasswordResetRequestDAOFactory factory=null;
      PersistentPasswordResetRequest pRequest=null;
      UserContext ctx=null;
      UserData userData=null;
      
      userData=UserData.getInstance();
      ctx=UserContextDAOFactory.authenticate(userData.getAdminUserName(),
            userData.getAdminPassword());      
      factory=new PasswordResetRequestDAOFactory();
      dao=factory.getDAO();
      newRequest=dao.create();
      testCase=new TestCasePasswordResetRequest1();
      
      newRequest.setAddressOfRequest(testCase.getAddressOfRequest());
      newRequest.setDateSubmitted(testCase.getDateSubmitted());
      newRequest.setExpirationDate(testCase.getExpirationDate());
      try {
         newRequest.setUserName(testCase.getUserName());
      } catch (UserNameTooLongException ex) {
         logger.log(
               Level.SEVERE,
               "UserNameTooLongException Thrown",
               ex);
      } // END try/catch
      pRequest=dao.save(newRequest, ctx);
      
      assert pRequest.getAddressOfRequest().equals(
            testCase.getAddressOfRequest());
      assert pRequest.getUserName().equals(
            testCase.getUserName());
      assert pRequest.getDateSubmitted().equals(
            testCase.getDateSubmitted());
      assert pRequest.getExpirationDate().equals(
            testCase.getExpirationDate());            
   }
   
   @Test
   public void testFindByName() {
      PasswordResetRequest testCase=null;
      PasswordResetRequestDAO dao=null;
      PasswordResetRequestDAOFactory factory=null;
      PersistentPasswordResetRequest pRequest=null;
      String userName="";
      UserContext ctx=null;
      UserData userData=null;
      
      userData=UserData.getInstance();
      ctx=UserContextDAOFactory.authenticate(userData.getAdminUserName(),
            userData.getAdminPassword());      
      factory=new PasswordResetRequestDAOFactory();
      dao=factory.getDAO();
      testCase=new TestCasePasswordResetRequest1();
      pRequest=dao.save(testCase, ctx);
      
      userName=testCase.getUserName();
      pRequest=dao.findByUserName(userName, ctx);
      
      assert pRequest != null;
      assert pRequest.getAddressOfRequest().equals(
            testCase.getAddressOfRequest());
      assert pRequest.getUserName().equals(
            testCase.getUserName());
      assert pRequest.getDateSubmitted().equals(
            testCase.getDateSubmitted());
      assert pRequest.getExpirationDate().equals(
            testCase.getExpirationDate());
   }
   
   @Test
   public void testFindByDate() {
      Calendar calendar=null;
      Date startDate=null;
      Date endDate=null;
      List<PersistentPasswordResetRequest> results=null;
      PasswordResetRequest testCase=null;
      PasswordResetRequestDAO dao=null;
      PasswordResetRequestDAOFactory factory=null;
      UserContext ctx=null;
      UserData userData=null;
      
      calendar=new GregorianCalendar();      
      calendar.add(Calendar.DAY_OF_MONTH, 1);
      
      userData=UserData.getInstance();
      ctx=UserContextDAOFactory.authenticate(userData.getAdminUserName(),
            userData.getAdminPassword());      
      factory=new PasswordResetRequestDAOFactory();
      dao=factory.getDAO();
      
      // Let's create the test cases
      testCase=new TestCasePasswordResetRequest1();
      testCase.setExpirationDate(calendar.getTime());
      dao.save(testCase, ctx);
      // Let's increment the calendar by one hour
      calendar.add(Calendar.HOUR, 1);
      startDate=calendar.getTime();
      testCase.setExpirationDate(startDate);
      dao.save(testCase, ctx);
      // Let's increment the calendar by another hour
      calendar.add(Calendar.HOUR, 1);
      testCase.setExpirationDate(calendar.getTime());
      dao.save(testCase, ctx);
      // Let's increment the calendar by another hour
      calendar.add(Calendar.HOUR, 1);
      testCase.setExpirationDate(calendar.getTime());
      dao.save(testCase, ctx);
      endDate=calendar.getTime();
      // Let's have one more item that is beyond the endDate
      calendar.add(Calendar.HOUR, 1);
      testCase.setExpirationDate(calendar.getTime());
      dao.save(testCase, ctx);
      
      // Let's sleep for 1 second to allow for eventual consistency
      try {
         Thread.sleep(1000);         
      } catch (InterruptedException ex) {
         ex.printStackTrace(System.err);
      } // END try/catch
      
      results=dao.findByExpirationDate(startDate, endDate, ctx);
      
      assert results != null;
      assert results.size() == 3;      
   }
   
   @Test(expectedExceptions = IllegalArgumentException.class)
   public void testFindByDateNoDates() {
      @SuppressWarnings("unused")
      List<PersistentPasswordResetRequest> results=null;
      PasswordResetRequestDAO dao=null;
      PasswordResetRequestDAOFactory factory=null;
      UserContext ctx=null;
      UserData userData=null;
      
      userData=UserData.getInstance();
      ctx=UserContextDAOFactory.authenticate(userData.getAdminUserName(),
            userData.getAdminPassword());      
      factory=new PasswordResetRequestDAOFactory();
      dao=factory.getDAO();
      results=dao.findByExpirationDate(null, null, ctx);      
   }
   
   /**
    * Invokes the {@code findByDate} method of the 
    * {@code PasswordResetRequestDAO} specifying a null value for the
    * {@code startDate} parameter and a past date as a value for the 
    * {@code endDate} parameter. This should throw an IllegalArgumentException
    * exception.
    */
   @Test(expectedExceptions = IllegalArgumentException.class)
   public void testFindByDateBadEndDate() {
      Calendar calendar=null;
      Date endDate=null;
      @SuppressWarnings("unused")
      List<PersistentPasswordResetRequest> results=null;
      PasswordResetRequestDAO dao=null;
      PasswordResetRequestDAOFactory factory=null;
      UserContext ctx=null;
      UserData userData=null;
      
      calendar=new GregorianCalendar();
      calendar.add(Calendar.HOUR, -1);
      endDate=calendar.getTime();
      
      userData=UserData.getInstance();
      ctx=UserContextDAOFactory.authenticate(userData.getAdminUserName(),
            userData.getAdminPassword());      
      factory=new PasswordResetRequestDAOFactory();
      dao=factory.getDAO();
      results=dao.findByExpirationDate(null, endDate, ctx);
   }
}