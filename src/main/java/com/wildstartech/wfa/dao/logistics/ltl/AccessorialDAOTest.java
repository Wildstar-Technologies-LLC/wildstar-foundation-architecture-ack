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
package com.wildstartech.wfa.dao.logistics.ltl;

import java.util.Date;

import org.testng.annotations.Test;

import com.wildstartech.wfa.dao.UserData;
import com.wildstartech.wfa.dao.UserContext;
import com.wildstartech.wfa.dao.UserContextDAOFactory;
import com.wildstartech.wfa.dao.WildDAOTest;
import com.wildstartech.wfa.dao.WildObject;
import com.wildstartech.wfa.finance.ChargeDescriptionTooLongException;
import com.wildstartech.wfa.logistics.ltl.AccessorialCharge;

/**
 * Test case for the GAE implementation of the<code>AccessorialDAO</code> class.
 * 
 * @author Derek Berube, Wildstar Technologies, LLC.
 * @version 1.0
 */
public class AccessorialDAOTest extends WildDAOTest {
	@Test
	public void testFactory() {
		AccessorialChargeDAO dao = null;
		AccessorialChargeDAOFactory factory = null;
		factory = new AccessorialChargeDAOFactory();
		dao = factory.getDAO();
		assert dao != null;
	}

	@Test(dependsOnMethods = { "testFactory" })
	public void testCreate() {
		AccessorialCharge charge = null;
		AccessorialChargeDAO dao = null;
		AccessorialChargeDAOFactory factory = null;

		factory = new AccessorialChargeDAOFactory();
		dao = factory.getDAO();
		charge = dao.create();
		assert charge != null;
		assert charge instanceof AccessorialCharge;
		assert charge instanceof PersistentAccessorialCharge;
		assert charge instanceof WildObject;
		assert charge instanceof PersistentAccessorialCharge;
	}

	@Test(dependsOnMethods = { "testCreate" })
	public void testSave() {
		AccessorialCharge charge=null;
		AccessorialCharge testCharge = null;
		AccessorialChargeDAO dao = null;
		AccessorialChargeDAOFactory factory = null;
		Date createDate = null;
		Date modifiedDate = null;
		PersistentAccessorialCharge pCharge = null;
		UserContext ctx = null;
		UserData userData=null;

		userData=UserData.getInstance();
		ctx = UserContextDAOFactory.authenticate(userData.getAdminUserName(), userData.getAdminPassword());
		factory=new AccessorialChargeDAOFactory();
		dao=factory.getDAO();
		charge=dao.create();
		testCharge=new TestCaseAccessorialCharge1();
		
		charge.setAmount(testCharge.getAmount());
		try {
			charge.setDescription(testCharge.getDescription());
		} catch (ChargeDescriptionTooLongException ex) {
			ex.printStackTrace(System.err);
		} // END try/catch
		charge.setQuantity(testCharge.getQuantity());
		
		dao = new AccessorialChargeDAOFactory().getDAO();
		pCharge =  dao.save(charge, ctx);
		assert pCharge != null;
		assert pCharge.getAmount() == testCharge.getAmount();
		assert pCharge.getDescription().equals(testCharge.getDescription());
		assert pCharge.getQuantity() == testCharge.getQuantity();
		assert pCharge.getIdentifier() != null;
		// Ensure the user who modified the object is the admin user
		assert pCharge.getModifiedBy().compareTo(userData.getAdminUserName()) == 0;
		// Validate dateCreated
		createDate = pCharge.getDateCreated();
		assert createDate != null;
		/*
		 * Ensure the value stored as the dateCreated is within 1000
		 * milliseconds of the present.
		 */
		// assert new Date().getTime() - 1000 <= createDate.getTime();
		// Validate dateModified
		modifiedDate = pCharge.getDateModified();
		assert modifiedDate != null;
		// Ensure the modified date is equal to the createDate.
		assert modifiedDate.getTime() == createDate.getTime();		
	}

	@Test(dependsOnMethods = { "testSave" })
	public void testFindInstance() {
		AccessorialCharge template = null;
		PersistentAccessorialCharge foundCharge = null;
		AccessorialChargeDAO dao = null;
		UserContext ctx = null;
		UserData userData=null;

		userData=UserData.getInstance();
		ctx = UserContextDAOFactory.authenticate(userData.getAdminUserName(), userData.getAdminPassword());
		dao = new AccessorialChargeDAOFactory().getDAO();
		template = new TestCaseAccessorialCharge1();
		
		foundCharge = dao.findInstance(template, ctx);
		assert foundCharge != null;
		assert foundCharge.getAmount().doubleValue() == template.getAmount().doubleValue();
		assert foundCharge.getDescription().equals(template.getDescription());
		assert foundCharge.getQuantity() == template.getQuantity();
		assert ((PersistentAccessorialCharge) foundCharge).getQuoteIdentifier()
				.equals(((PersistentAccessorialCharge) template).getQuoteIdentifier());		
	}
}