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
package com.wildstartech.wfa.dao.journal;

import java.util.Date;

import org.testng.annotations.Test;

import com.wildstartech.wfa.dao.UserContext;
import com.wildstartech.wfa.dao.UserContextDAOFactory;
import com.wildstartech.wfa.dao.UserData;
import com.wildstartech.wfa.dao.WildDAOTest;
import com.wildstartech.wfa.dao.journal.JournalDAO;
import com.wildstartech.wfa.dao.journal.JournalDAOFactory;
import com.wildstartech.wfa.dao.journal.PersistentJournalEntry;
import com.wildstartech.wfa.journal.JournalEntry;

public class JournalDAOTest extends WildDAOTest {

	@Test
	public void testCreate() {
		JournalDAOFactory factory = null;
		JournalDAO dao = null;
		JournalEntry entry = null;

		factory = new JournalDAOFactory();
		assert factory != null;
		dao = factory.getDAO();
		assert dao != null;
		entry = dao.create();
		assert entry != null;
	}

	@Test(dependsOnMethods = { "testCreate" })
	public void testSave() {
		Date tmpDate = null;
		JournalDAOFactory factory = null;
		JournalDAO dao = null;
		JournalEntry entry = null;
		JournalEntry testEntry = null;
		PersistentJournalEntry pEntry = null;
		String tmpStr = null;
		UserContext ctx = null;
		UserData userData=null;

		// Test Data
		testEntry = new TestCaseJournalEntry1();

		factory = new JournalDAOFactory();
		dao = factory.getDAO();
		userData=UserData.getInstance();
		assert dao != null;
		entry = dao.create();
		assert entry != null;
		entry.setCategory(testEntry.getCategory());
		entry.setDescription(testEntry.getDescription());
		entry.setEntryDate(testEntry.getEntryDate());
		entry.setContent(testEntry.getContent());
		ctx = UserContextDAOFactory.authenticate(
				userData.getAdminUserName(), 
				userData.getAdminPassword());
		assert ctx != null;
		assert ctx.isAuthenticated();
		entry = dao.save(entry, ctx);
		assert entry != null;
		assert entry instanceof PersistentJournalEntry;
		pEntry = (PersistentJournalEntry) entry;

		tmpStr = pEntry.getIdentifier();
		assert tmpStr != null;
		tmpDate = pEntry.getDateCreated();
		assert tmpDate != null;
		tmpStr = pEntry.getCreatedBy();
		assert tmpStr != null;
		tmpDate = pEntry.getDateModified();
		assert tmpDate != null;
		tmpStr = pEntry.getModifiedBy();
		assert tmpStr != null;
	}
}