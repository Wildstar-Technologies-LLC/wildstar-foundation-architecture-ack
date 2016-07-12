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

public class MockSimpleQuote extends MockQuickQuote implements SimpleQuote {
	private boolean assemblyRequired=false;
	private boolean blanketWrapRequired=false;
	private boolean cratingRequired=false;
	private boolean destinationResidential=false;
	private boolean originResidential=false;
	private boolean packagingRequired=false;
	private boolean stairCarry=false;
	private boolean unpackagingRequired=false;
	private int numberOfFlights=0;
	private String destinationCity="";
	private String destinationCompanyName="";
	private String destinationContactEmail="";
	private String destinationContactName="";
	private String destinationContactPhone="";
	private String destinationState="";
	private String destinationStreetAddress="";
	private String notes="";
	private String originCity="";
	private String originCompanyName="";
	private String originContactEmail="";
	private String originContactName="";
	private String originContactPhone="";
	private String originState="";
	private String originStreetAddress="";
	private String purchaseOrderNumber="";
	private String referralOther="";
	private String referralSource="";
	
	/**
	 * Default, no-argument constructor.
	 */
	public MockSimpleQuote() {
		super();
	}
	
	//***** assemblyRequired
	@Override
	public boolean isAssemblyRequired() {
		return this.assemblyRequired;
	}
	@Override
	public void setAssemblyRequired(boolean assemblyRequired) {
		this.assemblyRequired=assemblyRequired;
	}

	//***** blanketWrapRequired
	@Override
	public boolean isBlanketWrapRequired() {
		return this.blanketWrapRequired;
	}
	@Override
	public void setBlanketWrapRequired(boolean blanketWrapRequired) {
		this.blanketWrapRequired=blanketWrapRequired;
	}
	
	//***** cratingRequired
	@Override
	public boolean isCratingRequired() {
		return this.cratingRequired;
	}
	@Override
	public void setCratingRequired(boolean cratingRequired) {
		this.cratingRequired=cratingRequired;
	}

	//***** destinationCity
	@Override
	public String getDestinationCity() {
		return this.destinationCity;
	}
	@Override
	public void setDestinationCity(String destinationCity) {
		this.destinationCity=defaultValue(destinationCity);
	}

	//***** destinationCompanyName
	@Override
	public String getDestinationCompanyName() {
		return this.destinationCompanyName;
	}
	@Override
	public void setDestinationCompanyName(String destinationCompanyName) {
		this.destinationCompanyName=defaultValue(destinationCompanyName);
	}
	
	//***** destinationContactName
	@Override
	public String getDestinationContactEmail() {
		return this.destinationContactEmail;
	}
	@Override
	public void setDestinationContactEmail(String destinationContactEmail) {
		this.destinationContactEmail=defaultValue(destinationContactEmail);
	}

	//***** destinationContactName
	@Override
	public String getDestinationContactName() {
		return this.destinationContactName;
	}
	@Override
	public void setDestinationContactName(String destinationContactName) {
		this.destinationContactName=defaultValue(destinationContactName);
	}

	//***** destinationContactPhone
	@Override
	public String getDestinationContactPhone() {
		return this.destinationContactPhone;
	}
	@Override
	public void setDestinationContactPhone(String destinationContactPhone) {
		this.destinationContactPhone=defaultValue(destinationContactPhone);
	}

	//***** destinationResidential
	@Override
	public boolean isDestinationResidential() {
		return this.destinationResidential;
	}
	@Override
	public void setDestinationResidential(boolean residential) {
		this.destinationResidential=residential;
	}

	//***** destinationState
	@Override
	public String getDestinationState() {
		return this.destinationState;
	}
	@Override
	public void setDestinationState(String destinationState) {
		this.destinationState=defaultValue(destinationState);
	}

	//***** destinationStreetAddress
	@Override
	public String getDestinationStreetAddress() {
		return this.destinationStreetAddress;
	}
	@Override
	public void setDestinationStreetAddress(String destinationStreetAddress) {
		this.destinationStreetAddress=defaultValue(destinationStreetAddress);
	}

	//***** notes
	@Override
	public String getNotes() {
		return this.notes;
	}
	@Override
	public void setNotes(String notes) {
		this.notes=defaultValue(notes);
	}

	//***** numberOfFlights
	@Override
	public int getNumberOfFlights() {
		return this.numberOfFlights;
	}
	@Override
	public void setNumberOfFlights(int numberOfFlights) {		
		this.numberOfFlights=numberOfFlights;
	}

	//***** originCity
	@Override
	public String getOriginCity() {
		return this.originCity;
	}
	@Override
	public void setOriginCity(String originCity) {
		this.originCity=defaultValue(originCity);
	}

	//***** originCompanyName
	@Override
	public String getOriginCompanyName() {
		return this.originCompanyName;
	}
	@Override
	public void setOriginCompanyName(String originCompanyName) {
		this.originCompanyName=defaultValue(originCompanyName);
	}
	
	//***** originContactEmail
	@Override
	public String getOriginContactEmail() {
		return this.originContactEmail;
	}
	@Override
	public void setOriginContactEmail(String originContactEmail) {
		this.originContactEmail=defaultValue(originContactEmail);
	}
	
	//***** originContactName
	@Override
	public String getOriginContactName() {
		return this.originContactName;
	}
	@Override
	public void setOriginContactName(String originContactName) {
		this.originContactName=defaultValue(originContactName);
	}

	//***** originContactPhone
	@Override
	public String getOriginContactPhone() {
		return this.originContactPhone;
	}
	@Override
	public void setOriginContactPhone(String originContactPhone) {
		this.originContactPhone=defaultValue(originContactPhone);
	}

	//***** originResidential
	@Override
	public boolean isOriginResidential() {
		return this.originResidential;
	}
	@Override
	public void setOriginResidential(boolean residential) {
		this.originResidential=residential;
	}

	//***** originState
	@Override
	public String getOriginState() {
		return this.originState;
	}
	@Override
	public void setOriginState(String originState) {
		this.originState=originState;
	}

	//***** originStreetAddress
	@Override
	public String getOriginStreetAddress() {
		return this.originStreetAddress;
	}
	@Override
	public void setOriginStreetAddress(String originStreetAddress) {
		this.originStreetAddress=defaultValue(originStreetAddress);
	}

	//***** packagingRequired
	@Override
	public boolean isPackagingRequired() {
		return this.packagingRequired;
	}
	@Override
	public void setPackagingRequired(boolean packagingRequired) {
		this.packagingRequired=packagingRequired;
	}

	//***** purchaseOrderNumber
	@Override
	public String getPurchaseOrderNumber() {
		return this.purchaseOrderNumber;
	}
	@Override
	public void setPurchaseOrderNumber(String poNumber) {
		this.purchaseOrderNumber=defaultValue(poNumber);
	}

	//***** referralSource
	@Override
	public String getReferralSource() {
		return this.referralSource;
	}
	@Override
	public void setReferralSource(String referralSource) {
		this.referralSource=referralSource;

	}

	//***** referralOther
	@Override
	public String getReferralOther() {
		return this.referralOther;
	}
	@Override
	public void setReferralOther(String referralOther) {
		this.referralOther=referralOther;

	}

	//***** stairCarry
	@Override
	public boolean isStairCarry() {
		return this.stairCarry;
	}
	@Override
	public void setStairCarry(boolean value) {
		this.stairCarry=value;
	}

	//***** packagingRequired
	@Override
	public boolean isUnpackagingRequired() {
		return this.unpackagingRequired;
	}
	@Override
	public void setUnpackagingRequired(boolean unpackagingRequired) {
		this.unpackagingRequired=unpackagingRequired;
	}
}