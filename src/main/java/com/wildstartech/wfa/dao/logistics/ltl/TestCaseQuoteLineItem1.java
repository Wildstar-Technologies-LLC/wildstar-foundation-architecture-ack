package com.wildstartech.wfa.dao.logistics.ltl;

import com.wildstartech.wfa.logistics.ltl.MockQuoteLineItem;

public class TestCaseQuoteLineItem1 extends MockQuoteLineItem {
	public TestCaseQuoteLineItem1() {
		super();
		setLength(10);
		setWidth(20);
		setHeight(30);
		setWeight(40);
		setQuantity(10);
		setDescription("Test description for line item 1.");
	}
}