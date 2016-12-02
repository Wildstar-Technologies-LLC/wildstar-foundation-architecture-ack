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
package com.wildstartech.wfa.dao.logistics.ltl.quote;

import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

import com.wildstartech.wfa.dao.UserData;
import com.wildstartech.wfa.dao.WildDAOTest;
import com.wildstartech.wfa.dao.logistics.ltl.PersistentQuote;
import com.wildstartech.wfa.dao.logistics.ltl.PersistentQuoteLineItem;
import com.wildstartech.wfa.dao.logistics.ltl.QuoteDAO;
import com.wildstartech.wfa.dao.logistics.ltl.QuoteDAOFactory;
import com.wildstartech.wfa.dao.logistics.ltl.QuoteLineItemDAO;
import com.wildstartech.wfa.dao.logistics.ltl.QuoteLineItemDAOFactory;
import com.wildstartech.wfa.dao.user.UserContext;
import com.wildstartech.wfa.dao.user.UserContextDAOFactory;
import com.wildstartech.wfa.logistics.ltl.Quote;
import com.wildstartech.wfa.logistics.ltl.QuoteLineItem;

/**
 * Test case for the <code>QuoteDAO</code> class.
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
public class QuoteDAOTest extends WildDAOTest {
	
	/**
	 * Tests the ability to get a data access object from the DAO factory.
	 * 
	 */
	@Test
	public void testDAO() {
	   QuoteDAO dao=null;
	   QuoteDAOFactory factory=null;
	   
	   factory=new QuoteDAOFactory();
	   dao=factory.getDAO();
	   
	   assert dao != null;
	}
	/**
	 * Tests the basic creation of an <code>Quote</code> object.
	 * 
	 * <p>
	 * Performs a basic test of the data access object's ability to create an
	 * object that implements both the
	 * <code>com.wildstartech.wfa.logistics.ltl.Quote</code> interface and the
	 * <code>com.wildstartech.wfa.dao.logistics.ltl.PersistentQuote</code>
	 * interface.
	 * </p>
	 */
	@Test(dependsOnMethods={"testDAO"})
	public void testCreate() {
		QuoteDAO dao = null;
		QuoteDAOFactory factory = null;
		PersistentQuote pQuote=null;
		
		factory = new QuoteDAOFactory();
		dao = factory.getDAO();
		pQuote = (PersistentQuote) dao.create();
		assert pQuote instanceof Quote;
		assert pQuote instanceof PersistentQuote;
	}

	/**
	 * Tests the ability to properly save an instance of a <code>Quote</code>.
	 */
	@Test
	public void testSaveNoLineItems() {
		Date createDate = null;
		Date modifiedDate = null;
		PersistentQuote pQuote=null;
		Quote testCase=null;
		QuoteDAO dao = null;
		QuoteDAOFactory factory = null;
		String id = null;
		String name = null;
		UserContext ctx = null;
		UserData userData = null;

		userData = UserData.getInstance();
		ctx = UserContextDAOFactory.authenticate(
		      userData.getAdminUserName(), userData.getAdminPassword());
		assert ctx != null;
		// Let's prepare the data
		testCase=new TestCaseQuote1();
		
		// Let's get ready to save.
		factory = new QuoteDAOFactory();
		dao = factory.getDAO();
		pQuote = dao.save(testCase, ctx);
		id = pQuote.getIdentifier();
		assert id != null;
		name = pQuote.getCreatedBy();
		assert name != null;
		// Ensure the user who created the object is the admin user
		assert name.compareTo(userData.getAdminUserName()) == 0;
		name = pQuote.getModifiedBy();
		assert name != null;
		// Ensure the user who modified the object is the admin user
		assert name.compareTo(userData.getAdminUserName()) == 0;
		// Validate dateCreated
		createDate = pQuote.getDateCreated();
		assert createDate != null;
		/*
		 * Ensure the value stored as the dateCreated is within 1000
		 * milliseconds of the present.
		 */
		assert new Date().getTime() - 1000 <= createDate.getTime();
		// Validate dateModified
		modifiedDate = pQuote.getDateModified();
		assert modifiedDate != null;
		// Ensure the modified date is equal to the createDate.
		assert modifiedDate.getTime() == createDate.getTime();

		assert pQuote.getContactName().compareTo(testCase.getContactName()) == 0;
		assert pQuote.getContactEmail().compareTo(testCase.getContactEmail()) == 0;
		assert pQuote.getContactPhone().compareTo(testCase.getContactPhone()) == 0;
		assert pQuote.getOriginCity().compareTo(testCase.getOriginCity()) == 0;
		assert pQuote.getOriginState().compareTo(testCase.getOriginState()) == 0;
		assert pQuote.getOriginZip().compareTo(testCase.getOriginZip()) == 0;
		assert pQuote.getDestinationCity().compareTo(testCase.getDestinationCity()) == 0;
		assert pQuote.getDestinationState().compareTo(testCase.getDestinationState()) == 0;
		assert pQuote.getDestinationZip().compareTo(testCase.getDestinationZip()) == 0;
		assert pQuote.getDistance() == testCase.getDistance();
		assert pQuote.getNotes().compareTo(testCase.getNotes()) == 0;		
	}

	@Test
	public void testFindByIdentifier() {
	   Quote testCase=null;
		PersistentQuote pQuote = null;
		QuoteDAO dao = null;
		String id = null;
		UserContext ctx = null;
		UserData userData = null;

		userData = UserData.getInstance();
		ctx = UserContextDAOFactory.authenticate(
		      userData.getAdminUserName(), userData.getAdminPassword());
		dao = new QuoteDAOFactory().getDAO();
		
		testCase=new TestCaseQuote1();
		pQuote=dao.save(testCase, ctx);
		id = pQuote.getIdentifier();
		pQuote = dao.findByIdentifier(id, ctx);

		assert pQuote != null;
		assert pQuote.getContactName().compareTo(testCase.getContactName()) == 0;
      assert pQuote.getContactEmail().compareTo(testCase.getContactEmail()) == 0;
      assert pQuote.getContactPhone().compareTo(testCase.getContactPhone()) == 0;
      assert pQuote.getOriginCity().compareTo(testCase.getOriginCity()) == 0;
      assert pQuote.getOriginState().compareTo(testCase.getOriginState()) == 0;
      assert pQuote.getOriginZip().compareTo(testCase.getOriginZip()) == 0;
      assert pQuote.getDestinationCity().compareTo(testCase.getDestinationCity()) == 0;
      assert pQuote.getDestinationState().compareTo(testCase.getDestinationState()) == 0;
      assert pQuote.getDestinationZip().compareTo(testCase.getDestinationZip()) == 0;
      assert pQuote.getDistance() == testCase.getDistance();
      assert pQuote.getNotes().compareTo(testCase.getNotes()) == 0;
	}

	
}