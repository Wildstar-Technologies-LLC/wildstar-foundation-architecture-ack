package com.wildstartech.wfa.logistics.ltl;

import com.wildstartech.wfa.journal.JournalEntry;
import com.wildstartech.wfa.logistics.ltl.pricemodels.PriceModel;
import com.wildstartech.wfa.ticketing.MockBasicTicket;

public class MockQuickQuote extends MockBasicTicket implements QuickQuote {
	private boolean valuationDeclined=false;
	private double adjustmentAmount=0;
	private double amount=0;
	private double deductible=0;
	private double distance=0;
	private double fuelSurcharge=0;
	private double insuranceCharges=0;
	private double valuation=0;
	private int totalCubes=0;
	private int totalWeight=0;
	private AdjustmentType adjustmentType=null;
	private JournalEntry newJournalEntry=null;
	private PriceModel priceModel=null;
	private String contactCompanyName="";
	private String contactEmail="";
	private String contactName="";
	private String contactPhone="";
	private String customerReferenceNote="";
	private String destinationZip="";
	private String originZip="";
	private String orderType="";
	private String serviceLevel="";
	
	/**
	 * Default, no-argument constructor.
	 */
	public MockQuickQuote() {
		
	}
	
	//********** Utility
	/**
	 * Calculate rate
	 */
	@Override
	public void calculateRate() {		

	}
	//********** Accessorial Charges
	//***** adjustmentAmount
	@Override
	public double getAdjustmentAmount() {
		return this.adjustmentAmount;
	}
	@Override
	public void setAdjustmentAmount(double amount) {
		this.adjustmentAmount=amount;
	}

	//***** adjustmentType
	@Override
	public AdjustmentType getAdjustmentType() {
		return this.adjustmentType;
	}
	@Override
	public void setAdjustmentType(AdjustmentType type) {
		this.adjustmentType=type;
	}
	
	//***** amount
	@Override
	public double getAmount() {
		return this.amount;
	}
	@Override
	public void setAmount(double amount) {
		this.amount=amount;
	}

	//***** contactCompanyName
	@Override
	public String getContactCompanyName() {
		return this.contactCompanyName;
	}
	@Override
	public void setContactCompanyName(String companyName) {
		this.contactCompanyName=companyName;
	}

	//***** contactEmail
	@Override
	public String getContactEmail() {
		return this.contactEmail;
	}
	@Override
	public void setContactEmail(String contactEmail) {
		this.contactEmail=defaultValue(contactEmail);
	}

	//***** contactName
	@Override
	public String getContactName() {
		return this.contactName;
	}
	@Override
	public void setContactName(String contactName) {
		this.contactName=defaultValue(contactName);
	}

	//***** contactPhone
	@Override
	public String getContactPhone() {
		return this.contactPhone;
	}
	@Override
	public void setContactPhone(String contactPhone) {
		this.contactPhone=contactPhone;
	}

	//***** customerReferenceNote
	@Override
	public String getCustomerReferenceNote() {
		return this.customerReferenceNote;
	}
	@Override
	public void setCustomerReferenceNote(String note) {
		this.customerReferenceNote=defaultValue(note);
	}

	//***** deductible
	@Override
	public double getDeductible() {
		return this.deductible;
	}
	@Override
	public void setDeductible(double amount) {
		this.deductible=amount;
	}

	//***** destinationZip
	@Override
	public String getDestinationZip() {
		return this.destinationZip;
	}
	@Override
	public void setDestinationZip(String destinationZip) {
		this.destinationZip=defaultValue(destinationZip);
	}

	//***** distance
	@Override
	public double getDistance() {
		return this.distance;
	}
	@Override
	public void setDistance(double distance) {
		this.distance=distance;
	}

	//***** fuelSurcharge
	@Override
	public double getFuelSurcharge() {
		return this.fuelSurcharge;
	}
	@Override
	public void setFuelSurcharge(double fuelSurcharge) {
		this.fuelSurcharge=fuelSurcharge;
	}

	//***** insuranceCharges
	@Override
	public double getInsuranceCharges() {
		return this.insuranceCharges;
	}
	@Override
	public void setInsuranceCharges(double insuranceCharge) {
		this.insuranceCharges=insuranceCharge;
	}
	
	//***** newJournalEntry
	@Override 
	public JournalEntry getNewJournalEntry() {
		return this.newJournalEntry;
	}
	@Override
	public void setNewJournalEntry(JournalEntry entry) {
		this.newJournalEntry=entry;
	}
	
	//***** orderType
	@Override
	public String getOrderType() {
		return this.orderType;
	}
	@Override
	public void setOrderType(String orderType) {
		this.orderType=defaultValue(orderType);
	}

	//***** originZip
	@Override
	public String getOriginZip() {
		return this.originZip;
	}
	@Override
	public void setOriginZip(String originZip) {
		this.originZip=defaultValue(originZip);
	}

	//***** priceModel
	@Override
	public PriceModel getPriceModel() {
		return this.priceModel;
	}
	@Override
	public void setPriceModel(PriceModel model) {
		this.priceModel=model;
	}

	//***** serviceLevel
	@Override
	public String getServiceLevel() {
		return this.serviceLevel;
	}
	@Override
	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel=defaultValue(serviceLevel);
	}

	//***** totalCubes
	@Override
	public int getTotalCubes() {
		return this.totalCubes;
	}
	@Override
	public void setTotalCubes(int totalCubes) {
		this.totalCubes=totalCubes;
	}

	//***** totalWeight
	@Override
	public int getTotalWeight() {
		return this.totalWeight;
	}
	@Override
	public void setTotalWeight(int weight) {
		this.totalWeight=weight;
	}

	//***** valuation
	@Override
	public double getValuation() {
		return this.valuation;
	}
	@Override
	public void setValuation(double valuation) {
		this.valuation=valuation;
	}
	
	//***** valuationDeclined
	@Override
	public boolean isValuationDeclined() {
		return this.valuationDeclined;
	}
	@Override
	public void setValuationDeclined(boolean valuationDeclined) {
		this.valuationDeclined = valuationDeclined;
	}
}