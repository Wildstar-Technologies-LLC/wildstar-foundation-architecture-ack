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
package com.wildstartech.wfa.logistics.ltl;

import java.util.ArrayList;
import java.util.List;

import com.wildstartech.wfa.logistics.ltl.quote.Quote;
import com.wildstartech.wfa.logistics.ltl.quote.QuoteLineItem;

public class MockQuote extends MockSimpleQuote implements Quote {
	private double accessorialTotal=0;
	private double lineItemCharges=0;
	private int creditCardExpirationYear=2016;
	private int creditCardExpirationMonth=1;
	private List<AccessorialCharge> accessorialCharges=null;
	private List<QuoteLineItem> lineItems=null;
	private String billingCity="";
	private String billingCompanyName="";
	private String billingContactEmail="";
	private String billingContactName="";
	private String billingContactPhone="";
	private String billingMethod="";
	private String billingState="";
	private String billingStreetAddress="";
	private String billingZip="";
	private String creditCardName="";
	private String creditCardNumber="";
	private String creditCardType="";
	private String creditCardVerification="";
	private String paymentMethod="";
	private String workOrderRequestId="";
	/**
	 * Default, no-argument constructor.
	 */
	public MockQuote() {
		super();
	}
	
	//***** accessorials
	@Override
	public double getAccessorialTotal() {
		return this.accessorialTotal;
	}
	@Override
	public List<AccessorialCharge> getAccessorialCharges() {
		return this.accessorialCharges;
	}
	@Override
	public AccessorialCharge addAccessorialCharge(AccessorialCharge charge) {
		boolean result=false;
		AccessorialCharge aCharge=null;
		
		if (this.accessorialCharges == null) {
			this.accessorialCharges=new ArrayList<AccessorialCharge>();
		} // END if (this.accessorialCharges == null)
		result=this.accessorialCharges.add(charge);
		if (result) {
			aCharge=charge;
		} // END if (result)
		
		return aCharge;
	}
	@Override
	public AccessorialCharge getAccessorialCharge(int i) {
		AccessorialCharge charge=null;
		if (
				(i >= 0) &&
				(i < this.accessorialCharges.size())
		   ) {
			charge=this.accessorialCharges.get(i);
		} else {
			throw new IndexOutOfBoundsException();
		} // END if ((i >= 0) && (i < this.accessorialCharges.size())
		return charge;
	}
	@Override
	public boolean removeAccessorialCharge(AccessorialCharge charge) {
		boolean result=false; 
		if (this.accessorialCharges.contains(charge)) {
			result=this.accessorialCharges.remove(charge);
		} // END if (this.accessorialCharges.contains(charge))	
		return result;
	}
	//***** billingCity
	@Override
	public String getBillingCity() {
		return this.billingCity;
	}

	@Override
	public void setBillingCity(String billingCity) {
		this.billingCity=defaultValue(billingCity);
	}
	
	//***** billingCompanyName
	@Override
	public String getBillingCompanyName() {
		return this.billingCompanyName;
	}
	@Override
	public void setBillingCompanyName(String companyName) {
		this.billingCompanyName=companyName;
	}
	
	//***** billingContactEmail
	@Override
	public String getBillingContactEmail() {
		return this.billingContactEmail;
	}
	@Override
	public void setBillingContactEmail(String contactEmail) {
		this.billingContactEmail=contactEmail;
	}
	
	//***** billingContactName
	@Override
	public String getBillingContactName() {
		return this.billingContactName;
	}
	@Override
	public void setBillingContactName(String contactName) {
		this.billingContactName=contactName;
	}

	//***** billingContactPhone
	@Override
	public String getBillingContactPhone() {
		return this.billingContactPhone;
	}
	@Override
	public void setBillingContactPhone(String contactPhone) {
		this.billingContactPhone=contactPhone;
	}

	//***** billingMethod
	@Override
	public String getBillingMethod() {
		return this.billingMethod;
	}
	@Override
	public void setBillingMethod(String billingMethod) {
		this.billingMethod=billingMethod;
	}

	//***** billingState
	@Override
	public String getBillingState() {
		return this.billingState;
	}
	@Override
	public void setBillingState(String billingState) {
		this.billingState=billingState;		
	}

	//***** billingStreetAddress
	@Override
	public String getBillingStreetAddress() {
		return this.billingStreetAddress;
	}

	@Override
	public void setBillingStreetAddress(String address) {
		this.billingStreetAddress=defaultValue(address);
	}

	//***** billingZip
	@Override
	public String getBillingZip() {
		return this.billingZip;
	}
	@Override
	public void setBillingZip(String billingZip) {
		this.billingZip=billingZip;
	}

	//***** creditCardExpirationMonth
	@Override
	public int getCreditCardExpirationMonth() {
		return this.creditCardExpirationMonth;
	}
	@Override
	public void setCreditCardExpirationMonth(int expirationMonth) {
		this.creditCardExpirationMonth=expirationMonth;
	}

	//***** creditCardExpirationYear
	@Override
	public int getCreditCardExpirationYear() {
		return this.creditCardExpirationYear;
	}
	@Override
	public void setCreditCardExpirationYear(int expirationYear) {
		this.creditCardExpirationYear=expirationYear;
	}

	//***** creditCardName
	@Override
	public String getCreditCardName() {
		return this.creditCardName;
	}
	@Override
	public void setCreditCardName(String cardName) {
		this.creditCardName=cardName;
	}

	//***** creditCardNumber
	@Override
	public String getCreditCardNumber() {
		return this.creditCardNumber;
	}
	@Override
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber=creditCardNumber;
	}
	
	//***** creditCardType
	@Override
	public String getCreditCardType() {
		return this.creditCardType;
	}
	@Override
	public void setCreditCardType(String creditCardType) {
		this.creditCardType=creditCardType;		
	}

	//***** creditCardVerification
	@Override
	public String getCreditCardVerification() {
		return this.creditCardVerification;
	}
	@Override
	public void setCreditCardVerification(String ccv) {
		this.creditCardVerification=defaultValue(ccv);
	}

	//***** paymentMethod
	@Override
	public String getPaymentMethod() {
		return this.paymentMethod;
	}
	@Override
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod=paymentMethod;
	}

	//***** lineItems
	@Override
	public List<QuoteLineItem> getLineItems() {
		return this.lineItems;
	}
	@Override
	public QuoteLineItem addLineItem(QuoteLineItem item) {
		QuoteLineItem aItem=null;
		boolean result=false;
		if (this.lineItems == null) {
			this.lineItems=new ArrayList<QuoteLineItem>();
		} // END if (this.lineItems == null)
		result=this.lineItems.add(item);
		if (result) {
			aItem=item;
		} // END if (result)
		return aItem;
	}
	@Override
	public QuoteLineItem createLineItem() {
		QuoteLineItem lineItem=null;
		lineItem=new MockQuoteLineItem();		
		return lineItem;
	}
	@Override
	public boolean removeLineItem(QuoteLineItem item) {
		boolean result=false;
		if (this.lineItems.contains(item)) {
			result=this.lineItems.remove(item);
		} // END if (this.lineItems.contains(item))
		return result;
	}
	@Override
	public QuoteLineItem getLineItem(int i) {
		QuoteLineItem item=null;
		if (
				(i >= 0) &&
				(i < this.lineItems.size())
		   ) {
			item=this.lineItems.get(i);
		} else {
			throw new IndexOutOfBoundsException();
		} // END if ((i >= 0) && (i < this.lineItems.size())
		return item;
	}
	
	//***** lineItemCharges
	@Override
	public double getLineItemCharges() {
		return this.lineItemCharges;
	}
	public void setLineItemCharges(double charges) {
		this.lineItemCharges=charges;
	}

	//***** workOrderRequestId
	@Override
	public String getWorkOrderRequestId() {
		return this.workOrderRequestId;
	}
	@Override
	public void setWorkOrderRequestId(String workOrderRequestId) {
		this.workOrderRequestId=defaultValue(workOrderRequestId);
	}
}