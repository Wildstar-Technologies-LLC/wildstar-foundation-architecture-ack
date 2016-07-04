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