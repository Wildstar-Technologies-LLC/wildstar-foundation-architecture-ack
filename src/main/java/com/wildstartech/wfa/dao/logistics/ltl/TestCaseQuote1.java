package com.wildstartech.wfa.dao.logistics.ltl;

import com.wildstartech.wfa.logistics.ltl.AccessorialCharge;
import com.wildstartech.wfa.logistics.ltl.MockQuote;
import com.wildstartech.wfa.logistics.ltl.QuoteLineItem;

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