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

import com.wildstartech.wfa.dao.logistics.ltl.TestCaseAccessorialCharge1;
import com.wildstartech.wfa.dao.logistics.ltl.TestCaseAccessorialCharge2;
import com.wildstartech.wfa.logistics.ltl.AccessorialCharge;
import com.wildstartech.wfa.logistics.ltl.MockQuote;
import com.wildstartech.wfa.logistics.ltl.quote.QuoteLineItem;

public class TestCaseQuote1 extends MockQuote {
	public TestCaseQuote1() {
		super();
		AccessorialCharge charge=null;
		QuoteLineItem item=null;
		
		// Set Basic Quote Information
		setDistance(327.63f);
		setContactName("Derek Berube");
		setContactPhone("404-444-5283");
		setContactEmail("derek.berube@me.com");
		setOriginCity("Panama City Beach");
		setOriginState("FL");
		setOriginZip("32413");
		setDestinationCity("Suwanee");
		setDestinationState("GA");
		setDestinationZip("30024");
		setNotes("Some notes would go here.");
		  
		// Add Line Items
		item=new TestCaseQuoteLineItem1();
		addLineItem(item);
		item=new TestCaseQuoteLineItem2();
		addLineItem(item);
		// Add Accessorials
		charge=new TestCaseAccessorialCharge1();
		addAccessorialCharge(charge);
		charge=new TestCaseAccessorialCharge2();
		addAccessorialCharge(charge);
	}
}