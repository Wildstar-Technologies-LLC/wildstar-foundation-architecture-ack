package com.wildstartech.wfa.logistics.ltl;

import java.math.BigDecimal;

import com.wildstartech.wfa.MockObject;
import com.wildstartech.wfa.finance.ChargeDescriptionTooLongException;

public class MockAccessorialCharge extends MockObject 
implements AccessorialCharge {
	private int quantity=0;
	private BigDecimal amount=new BigDecimal(0);
	private String description="";
	
	public MockAccessorialCharge() {
		super();
	}
	
	//***** description
	@Override
	public String getDescription() {
		return this.description;
	}
	@Override
	public void setDescription(String description) 
			throws ChargeDescriptionTooLongException {
		this.description=description;
	}

	//***** amount
	@Override
	public BigDecimal getAmount() {
		return this.amount;
	}
	@Override
	public void setAmount(BigDecimal amount) {
		this.amount=amount;
	}
	@Override
	public void setAmount(int amount) {
		this.amount=new BigDecimal(amount);
	}
	@Override
	public void setAmount(double amount) {
		this.amount=new BigDecimal(amount);
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	@Override
	public int getQuantity() {
		return this.quantity;
	}

	@Override
	public BigDecimal getTotalAmount() {	
		return this.amount.multiply(new BigDecimal(this.quantity));
	}
}