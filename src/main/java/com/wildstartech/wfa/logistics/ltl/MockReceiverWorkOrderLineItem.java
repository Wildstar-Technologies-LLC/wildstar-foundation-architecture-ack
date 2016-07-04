package com.wildstartech.wfa.logistics.ltl;

import com.wildstartech.wfa.journal.JournalEntry;
import com.wildstartech.wfa.logistics.MockWarehouseLocation;
import com.wildstartech.wfa.logistics.WarehouseLocation;

public class MockReceiverWorkOrderLineItem 
extends MockLineItem
implements ReceiverWorkOrderLineItem {
   private boolean hasException=false;
   private JournalEntry newJournalEntry=null;
   private String exceptionDescription="";
   private WarehouseLocation warehouseLocation=null; 
   
   public MockReceiverWorkOrderLineItem() {
	   super();
	   this.warehouseLocation=new MockWarehouseLocation();
   }
   
   @Override
   public JournalEntry getNewJournalEntry() {
      return this.newJournalEntry;
   }

   @Override
   public void setNewJournalEntry(JournalEntry entry) {
      this.newJournalEntry=entry;
   }

   @Override
   public WarehouseLocation getLocation() {
      return this.warehouseLocation;
   }

   @Override
   public void setLocation(WarehouseLocation location) {
      this.warehouseLocation=location;
   }

   @Override
   public boolean hasException() {
      return this.hasException;
   }

   @Override
   public void setException(boolean exception) {
      this.hasException=exception;
   }

   @Override
   public String getExceptionDescription() {
      return this.exceptionDescription;
   }

   @Override
   public void setExceptionDescription(String description) {
      this.exceptionDescription=description;      
   }
}