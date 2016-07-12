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
package com.wildstartech.wfa.dao.logistics.ltl;

import java.util.Date;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wildstartech.wfa.dao.UserData;
import com.wildstartech.wfa.dao.UserContext;
import com.wildstartech.wfa.dao.UserContextDAOFactory;
import com.wildstartech.wfa.dao.WildDAOTest;
import com.wildstartech.wfa.dao.logistics.ltl.PersistentQuote;
import com.wildstartech.wfa.dao.logistics.ltl.PersistentQuoteLineItem;
import com.wildstartech.wfa.dao.logistics.ltl.QuoteDAO;
import com.wildstartech.wfa.dao.logistics.ltl.QuoteDAOFactory;
import com.wildstartech.wfa.dao.logistics.ltl.QuoteLineItemDAO;
import com.wildstartech.wfa.dao.logistics.ltl.QuoteLineItemDAOFactory;
import com.wildstartech.wfa.dao.logistics.ltl.TestCaseQuote1;
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
	private PersistentQuote quote = null;
	// Quote Test Data
	private Quote testCase1;

	@BeforeClass
	public void initializeTestCases() {
		this.testCase1 = new TestCaseQuote1();
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
	@Test
	public void testCreate() {
		QuoteDAO dao = null;
		QuoteDAOFactory factory = null;

		factory = new QuoteDAOFactory();
		dao = factory.getDAO();
		this.quote = (PersistentQuote) dao.create();
		assert this.quote instanceof Quote;
		assert this.quote instanceof PersistentQuote;
	}

	/**
	 * Tests the ability to properly save an instance of a <code>Quote</code>.
	 */
	@Test(dependsOnMethods = { "testCreate" })
	public void testSaveNoLineItems() {
		Date createDate = null;
		Date modifiedDate = null;
		QuoteDAO dao = null;
		QuoteDAOFactory factory = null;
		String id = null;
		String name = null;
		UserContext ctx = null;
		UserData userData = null;

		userData = UserData.getInstance();
		ctx = UserContextDAOFactory.authenticate(userData.getAdminUserName(), userData.getAdminPassword());
		assert ctx != null;
		// Let's prepare the data
		this.quote.setContactName(this.testCase1.getContactName());
		this.quote.setContactPhone(this.testCase1.getContactPhone());
		this.quote.setContactEmail(this.testCase1.getContactEmail());
		this.quote.setOriginCity(this.testCase1.getOriginCity());
		this.quote.setOriginState(this.testCase1.getOriginState());
		this.quote.setOriginZip(this.testCase1.getOriginZip());
		this.quote.setDestinationCity(this.testCase1.getDestinationCity());
		this.quote.setDestinationState(this.testCase1.getDestinationState());
		this.quote.setDestinationZip(this.testCase1.getDestinationZip());
		this.quote.setDistance(this.testCase1.getDistance());
		this.quote.setNotes(this.testCase1.getNotes());
		// Let's get ready to save.
		factory = new QuoteDAOFactory();
		dao = factory.getDAO();
		this.quote = dao.save(this.quote, ctx);
		id = this.quote.getIdentifier();
		assert id != null;
		name = this.quote.getCreatedBy();
		assert name != null;
		// Ensure the user who created the object is the admin user
		assert name.compareTo(userData.getAdminUserName()) == 0;
		name = this.quote.getModifiedBy();
		assert name != null;
		// Ensure the user who modified the object is the admin user
		assert name.compareTo(userData.getAdminUserName()) == 0;
		// Validate dateCreated
		createDate = this.quote.getDateCreated();
		assert createDate != null;
		/*
		 * Ensure the value stored as the dateCreated is within 1000
		 * milliseconds of the present.
		 */
		assert new Date().getTime() - 1000 <= createDate.getTime();
		// Validate dateModified
		modifiedDate = this.quote.getDateModified();
		assert modifiedDate != null;
		// Ensure the modified date is equal to the createDate.
		assert modifiedDate.getTime() == createDate.getTime();

		assert this.quote.getContactName().compareTo(this.testCase1.getContactName()) == 0;
		assert this.quote.getContactEmail().compareTo(this.testCase1.getContactEmail()) == 0;
		assert this.quote.getContactPhone().compareTo(this.testCase1.getContactPhone()) == 0;
		assert this.quote.getOriginCity().compareTo(this.testCase1.getOriginCity()) == 0;
		assert this.quote.getOriginState().compareTo(this.testCase1.getOriginState()) == 0;
		assert this.quote.getOriginZip().compareTo(this.testCase1.getOriginZip()) == 0;
		assert this.quote.getDestinationCity().compareTo(this.testCase1.getDestinationCity()) == 0;
		assert this.quote.getDestinationState().compareTo(this.testCase1.getDestinationState()) == 0;
		assert this.quote.getDestinationZip().compareTo(this.testCase1.getDestinationZip()) == 0;
		assert this.quote.getDistance() == this.testCase1.getDistance();
		assert this.quote.getNotes().compareTo(this.testCase1.getNotes()) == 0;		
	}

	@Test(dependsOnMethods = { "testSaveNoLineItems" })
	public void testFindByIdentifier() {
		PersistentQuote pQuote = null;
		QuoteDAO dao = null;
		String id = null;
		UserContext ctx = null;
		UserData userData = null;

		userData = UserData.getInstance();
		ctx = UserContextDAOFactory.authenticate(userData.getAdminUserName(), userData.getAdminPassword());
		dao = new QuoteDAOFactory().getDAO();
		id = this.quote.getIdentifier();
		pQuote = dao.findByIdentifier(id, ctx);

		assert pQuote != null;
		assert pQuote.getContactName().compareTo(this.testCase1.getContactName()) == 0;
		assert pQuote.getContactEmail().compareTo(this.testCase1.getContactEmail()) == 0;
		assert pQuote.getContactPhone().compareTo(this.testCase1.getContactPhone()) == 0;
		assert pQuote.getOriginCity().compareTo(this.testCase1.getOriginCity()) == 0;
		assert pQuote.getOriginState().compareTo(this.testCase1.getOriginState()) == 0;
		assert pQuote.getOriginZip().compareTo(this.testCase1.getOriginZip()) == 0;
		assert pQuote.getDestinationCity().compareTo(this.testCase1.getDestinationCity()) == 0;
		assert pQuote.getDestinationState().compareTo(this.testCase1.getDestinationState()) == 0;
		assert pQuote.getDestinationZip().compareTo(this.testCase1.getDestinationZip()) == 0;
		assert pQuote.getDistance() == this.testCase1.getDistance();
		assert pQuote.getNotes().compareTo(this.testCase1.getNotes()) == 0;
	}

	/**
	 * Test the method to find ALL the quotes.
	 */
	@Test(dependsOnMethods = { "testSaveNoLineItems", "testFindByIdentifier" })
	public void testFindAllQuotes() {
		List<PersistentQuote> quotes = null;
		QuoteDAO dao = null;
		QuoteDAOFactory factory = null;
		UserContext ctx = null;
		UserData userData = null;

		userData = UserData.getInstance();
		// Log in.
		ctx = UserContextDAOFactory.authenticate(userData.getAdminUserName(), userData.getAdminPassword());
		factory = new QuoteDAOFactory();
		dao = factory.getDAO();
		quotes = dao.findAll(ctx);
		assert quotes != null;
		assert quotes.size() == 1;
	}

	@Test(dependsOnMethods = { "testFindAllQuotes" })
	public void testQuoteLineItems() {
		QuoteLineItem item = null;
		QuoteLineItem testItem = null;
		QuoteLineItemDAO dao = null;
		Date modifiedDate = null;
		QuoteDAO qDao = null;
		UserContext ctx = null;
		UserData userData = null;

		userData = UserData.getInstance();
		testItem = this.testCase1.getLineItem(0);
		ctx = UserContextDAOFactory.authenticate(userData.getAdminUserName(), userData.getAdminPassword());
		dao = new QuoteLineItemDAOFactory().getDAO();
		qDao = new QuoteDAOFactory().getDAO();
		item = dao.create();
		// Populate the line item with data.
		item.setDescription(testItem.getDescription());
		item.setHeight(testItem.getHeight());
		item.setLength(testItem.getLength());
		item.setWidth(testItem.getWidth());
		item.setWeight(testItem.getWeight());
		item.setQuantity(testItem.getQuantity());
		item.setDescription(testItem.getDescription());
		this.quote.addLineItem(item);
		this.quote = (PersistentQuote) qDao.save(this.quote, ctx);

		// Validate dateModified
		modifiedDate = this.quote.getDateModified();
		assert modifiedDate != null;
	}

	@Test(dependsOnMethods = { "testQuoteLineItems" })
	public void testQuoteLineItemSave() {
		List<QuoteLineItem> lineItems = null;
		Quote quote = null;
		QuoteDAO dao = null;
		QuoteLineItem lineItem = null;
		QuoteLineItem testItem = null;
		String quoteId = null;
		UserContext ctx = null;
		UserData userData = null;

		userData = UserData.getInstance();
		testItem = this.testCase1.getLineItem(0);
		ctx = UserContextDAOFactory.authenticate(userData.getAdminUserName(), userData.getAdminPassword());
		dao = new QuoteDAOFactory().getDAO();
		quoteId = this.quote.getIdentifier();
		quote = dao.findByIdentifier(quoteId, ctx);
		assert quote != null;
		lineItems = quote.getLineItems();
		assert lineItems != null;
		assert lineItems.size() == 1;
		lineItem = lineItems.get(0);
		assert lineItem != null;
		assert lineItem.getLength() == testItem.getLength();
		assert lineItem.getWidth() == testItem.getWidth();
		assert lineItem.getHeight() == testItem.getHeight();
		assert lineItem.getQuantity() == testItem.getQuantity();
		assert lineItem.getDescription().equals(testItem.getDescription());
	}

	@Test(dependsOnMethods = { "testQuoteLineItems", "testQuoteLineItemSave" })
	public void testCorrectLineItems() {
		QuoteLineItem newQli = null;
		QuoteLineItem testLineItem = null;
		QuoteLineItemDAO dao = null;
		List<QuoteLineItem> items = null;
		PersistentQuote quote = null;
		QuoteDAO qDao = null;
		UserContext ctx = null;
		UserData userData = null;

		userData = UserData.getInstance();
		testLineItem = this.testCase1.getLineItem(1);
		ctx = UserContextDAOFactory.authenticate(userData.getAdminUserName(), userData.getAdminPassword());
		dao = new QuoteLineItemDAOFactory().getDAO();
		qDao = new QuoteDAOFactory().getDAO();
		newQli = dao.create();
		newQli.setLength(testLineItem.getLength());
		newQli.setWidth(testLineItem.getWidth());
		newQli.setHeight(testLineItem.getHeight());
		newQli.setWeight(testLineItem.getWeight());
		newQli.setQuantity(testLineItem.getQuantity());
		newQli.setDescription(testLineItem.getDescription());
		newQli = dao.save(newQli, ctx);
		newQli = dao.findByIdentifier(((PersistentQuoteLineItem) newQli).getIdentifier(), ctx);
		assert newQli != null;
		quote = (PersistentQuote) qDao.findByIdentifier(this.quote.getIdentifier(), ctx);
		for (int i = 0; i < 1000; i++) {
			items = quote.getLineItems();
			assert items != null;
			assert items.size() == 1;
			items.get(0).setDescription("LineItem Description Updated " + i + " times.");
			quote = (PersistentQuote) qDao.save(quote, ctx);
		} // END for (int i=0; i < 1000; i++)

	}
}