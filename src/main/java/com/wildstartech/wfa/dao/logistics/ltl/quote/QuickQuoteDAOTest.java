/*
 * Copyright (c) 2001 - 2017 Wildstar Technologies, LLC.
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
package com.wildstartech.wfa.dao.logistics.ltl.quote;

import org.testng.annotations.Test;

import com.wildstartech.wfa.dao.UserData;
import com.wildstartech.wfa.dao.WildDAOTest;
import com.wildstartech.wfa.dao.user.UserContext;
import com.wildstartech.wfa.dao.user.UserContextDAOFactory;
import com.wildstartech.wfa.logistics.ltl.quote.QuickQuote;
import com.wildstartech.wfa.logistics.ltl.quote.Quote;
import com.wildstartech.wfa.logistics.ltl.quote.QuoteLineItem;

/**
 * Test case for the <code>QuickQuoteDAO</code> class.
 * 
 * <p>
 * This test case exercises the implementation of the <code>QuoteDAO</code>
 * interface from the <code>com.wildstartech.wfa.dao</code> package of the
 * Wildstar Foundation Architecture designed to run on the Google App Engine
 * persisting data in the Datastore. The following is a description of the test
 * methods execute for this class.
 * </p>
 * 
 * @author Derek Berube, Wildstar Technologies, LLC.
 * @version 0.1
 */
public class QuickQuoteDAOTest extends WildDAOTest {
   /**
    * Tests the ability to get a data access object from the DAO factory.
    * 
    */
   @Test
   public void testDAO() {
      QuickQuoteDAO dao=null;
      QuickQuoteDAOFactory factory=null;
      
      factory=new QuickQuoteDAOFactory();
      dao=factory.getDAO();
      assert dao != null;
      assert dao instanceof QuickQuoteDAO;
   }
   
   /**
    * Tests the basic creation of an <code>QuickQuote</code> object.
    * 
    * <p>
    * Performs a basic test of the data access object's ability to create an
    * object that implements both the
    * <code>com.wildstartech.wfa.logistics.ltl.quote.QuickQuote</code> interface and the
    * <code>com.wildstartech.wfa.dao.logistics.ltl.quote.PersistentQuickQuote</code>
    * interfaces.
    * </p>
    */
   @Test(dependsOnMethods={"testDAO"})
   public void testCreate() {
      QuickQuoteDAO dao = null;
      QuickQuoteDAOFactory factory = null;
      PersistentQuickQuote pQuickQuote=null;
      
      factory = new QuickQuoteDAOFactory();
      dao = factory.getDAO();
      pQuickQuote = dao.create();
      assert pQuickQuote instanceof QuickQuote;
      assert pQuickQuote instanceof PersistentQuickQuote;
   }
   
   @Test(dependsOnMethods="testCreate")
   public void testSave() {
      PersistentQuickQuote pQuote=null;
      QuickQuote testCase=null;
      QuickQuoteDAO dao=null;
      QuickQuoteDAOFactory factory=null;
      UserContext ctx=null;
      UserData userData=null;
      
      userData = UserData.getInstance();
      ctx = UserContextDAOFactory.authenticate(
            userData.getAdminUserName(), userData.getAdminPassword());
      assert ctx != null;
      testCase=new TestCaseQuickQuoteByCube1();
      factory=new QuickQuoteDAOFactory();
      dao=factory.getDAO();
      assert dao != null;
      pQuote=dao.save(testCase, ctx);
      assert pQuote != null;
      assert pQuote.getRequestId() != null;
      assert pQuote.getContactName().equals(testCase.getContactName());
      assert pQuote.getContactEmail().equals(testCase.getContactEmail());
      assert pQuote.getQuoteMethodLabel().equals(testCase.getQuoteMethodLabel());
      assert pQuote.getOriginZip().equals(testCase.getOriginZip());
      assert pQuote.getDestinationZip().equals(testCase.getDestinationZip());      
      assert pQuote.getServiceLevel().equals(testCase.getServiceLevel());
   }
   
   @Test(dependsOnMethods={"testSave"})
   public void testFindByRequestId() {
      PersistentQuickQuote pQuote=null;
      QuickQuote testCase=null;
      QuickQuoteDAO dao=null;
      QuickQuoteDAOFactory factory=null;
      String requestId=null;
      UserContext ctx=null;
      UserData userData=null;
      
      userData = UserData.getInstance();
      ctx = UserContextDAOFactory.authenticate(
            userData.getAdminUserName(), userData.getAdminPassword());
      assert ctx != null;
      testCase=new TestCaseQuickQuoteByCube1();
      factory=new QuickQuoteDAOFactory();
      dao=factory.getDAO();
      assert dao != null;
      pQuote=dao.save(testCase, ctx);
      requestId=pQuote.getRequestId();
      assert requestId != null;
      pQuote=(PersistentQuickQuote) dao.findByRequestId(requestId, ctx);
      assert pQuote != null;assert pQuote.getRequestId() != null;
      assert pQuote.getContactName().equals(testCase.getContactName());
      assert pQuote.getContactEmail().equals(testCase.getContactEmail());
      assert pQuote.getQuoteMethodLabel().equals(testCase.getQuoteMethodLabel());
      assert pQuote.getOriginZip().equals(testCase.getOriginZip());
      assert pQuote.getDestinationZip().equals(testCase.getDestinationZip());      
      assert pQuote.getServiceLevel().equals(testCase.getServiceLevel());
   }
   
   @Test(dependsOnMethods={"testSave"})
   public void testCrossDAOSaveRead() {
      int totalCubes=0;
      PersistentQuickQuote pQuickQuote=null;
      Quote quote=null;
      QuickQuote testCase=null;
      QuickQuoteDAO dao=null;
      QuickQuoteDAOFactory factory=null;
      QuoteDAO qDao=null;
      QuoteDAOFactory qFactory=null;
      String requestId=null;
      UserContext ctx=null;
      UserData userData=null;
      
      userData = UserData.getInstance();
      ctx = UserContextDAOFactory.authenticate(
            userData.getAdminUserName(), userData.getAdminPassword());
      assert ctx != null;
      
      testCase=new TestCaseQuickQuoteByCube1();
      totalCubes=testCase.getTotalCubes();
      factory=new QuickQuoteDAOFactory();
      dao=factory.getDAO();
      pQuickQuote=dao.save(testCase, ctx);
      requestId=pQuickQuote.getRequestId();
      
      // Now let's get the quote via the QuoteDAO
      qFactory=new QuoteDAOFactory();
      qDao=qFactory.getDAO();
      quote=qDao.findByRequestId(requestId,ctx);
      
      assert quote.getContactName().equals(testCase.getContactName());
      assert quote.getContactEmail().equals(testCase.getContactEmail());
      assert quote.getQuoteMethodLabel().equals(testCase.getQuoteMethodLabel());
      assert quote.getOriginZip().equals(testCase.getOriginZip());
      assert quote.getDestinationZip().equals(testCase.getDestinationZip());      
      assert quote.getServiceLevel().equals(testCase.getServiceLevel());   
      assert quote.getTotalCubes() == totalCubes;
   }
   
   @Test(dependsOnMethods={"testSave"})
   public void testCrossDAOSaveModify() {
      int totalCubes=0;
      PersistentQuickQuote pQuickQuote=null;
      QuickQuote qQuote=null;
      QuickQuote testCase=null;
      QuickQuoteDAO qDao=null;
      QuickQuoteDAOFactory qFactory=null;
      Quote quote=null;
      QuoteDAO dao=null;
      QuoteDAOFactory factory=null;
      QuoteLineItem qli=null;
      String newContactName="Updated Contact Name";
      String requestId=null;
      UserContext ctx=null;
      UserData userData=null;
      
      userData = UserData.getInstance();
      ctx = UserContextDAOFactory.authenticate(
            userData.getAdminUserName(), userData.getAdminPassword());
      assert ctx != null;
      
      testCase=new TestCaseQuickQuoteByCube1();
      qFactory=new QuickQuoteDAOFactory();
      qDao=qFactory.getDAO();
      pQuickQuote=qDao.save(testCase, ctx);
      requestId=pQuickQuote.getRequestId();
      
      // Read as Quote and add Line Item
      factory=new QuoteDAOFactory();
      dao=factory.getDAO();
      quote=dao.findByRequestId(requestId, ctx);
      qli=new TestCaseQuoteLineItem1();
      totalCubes = qli.getCube() * qli.getQuantity();
      quote.addLineItem(qli);
      quote=dao.save(quote, ctx);
      assert quote.getTotalCubes() == totalCubes;
      
      // Re-read as QuickQuote and Update the Contact Name
      qQuote=qDao.findByRequestId(requestId,ctx);
      assert totalCubes == qQuote.getTotalCubes();
      qQuote.setContactName(newContactName);
      qDao.save(qQuote, ctx);

      // Re-read as Quote and confirm contact name change is OK and
      quote=dao.findByRequestId(requestId, ctx);
      assert newContactName.equals(quote.getContactName());
      assert totalCubes == quote.getTotalCubes();      
   }
}