package com.wildstartech.wfa.dao.logistics.ltl;

import com.wildstartech.wfa.finance.ChargeDescriptionTooLongException;
import com.wildstartech.wfa.logistics.ltl.MockAccessorialCharge;

public class TestCaseAccessorialCharge2 extends MockAccessorialCharge {
	public TestCaseAccessorialCharge2() {
		setAmount(52.10f);
		setQuantity(5);
		try {
			setDescription("Second accessorial charge.");
		} catch (ChargeDescriptionTooLongException ex) {
			ex.printStackTrace(System.err);
		} // END try/catch
	}
}