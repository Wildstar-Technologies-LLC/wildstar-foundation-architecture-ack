package com.wildstartech.wfa.dao.logistics.ltl;

import com.wildstartech.wfa.finance.ChargeDescriptionTooLongException;
import com.wildstartech.wfa.logistics.ltl.MockAccessorialCharge;

public class TestCaseAccessorialCharge1 extends MockAccessorialCharge {
	public TestCaseAccessorialCharge1() {
		setAmount(100.52f); 
		setQuantity(1);
		try {
			setDescription("First accessorial charge.");
		} catch (ChargeDescriptionTooLongException ex) {
			ex.printStackTrace(System.err);
		} // END try/catch
	}

}
