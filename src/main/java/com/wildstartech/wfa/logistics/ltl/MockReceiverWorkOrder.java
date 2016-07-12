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
import java.util.Date;
import java.util.List;

import com.wildstartech.wfa.journal.JournalEntry;
import com.wildstartech.wfa.ticketing.MockBasicTicket;

public class MockReceiverWorkOrder extends MockBasicTicket
implements ReceiverWorkOrder {

   private Date dateReceived;
   private JournalEntry newJournalEntry=null;
   private List<ReceiverWorkOrderLineItem> lineItems=null;
   private String billOfLadingNumber="";
   private String depot="";
   private String inboundCarrier="";
   private String purchaseOrderNumber="";
   private String salesOrderNumber="";
   
   //***** billOfLadingNumber
   @Override
   public String getBillOfLadingNumber() {
      return this.billOfLadingNumber;
   }

   @Override
   public void setBillOfLadingNumber(String billOfLading) {
      this.billOfLadingNumber=billOfLading;
   }

   //***** carrier
   @Override
   public String getInboundCarrier() {
      return this.inboundCarrier;
   }

   @Override
   public void setInboundCarrier(String inboundCarrier) {
      this.inboundCarrier=inboundCarrier;
   }
   
   //***** dateReceived
   @Override
   public Date getDateReceived() {
      return this.dateReceived;
   }

   @Override
   public void setDateReceived(Date dateReceived) {
      this.dateReceived=dateReceived;
   }
 
   // ***** depot
   //@Override
   public String getDepot() {
      return this.depot;
   }
   //@Override
   public void setDepot(String depot) {
      this.depot=depot;      
   }
   //***** lineItems
   @Override
   public List<ReceiverWorkOrderLineItem> getLineItems() {
      return this.lineItems;
   }

   @Override
   public ReceiverWorkOrderLineItem addLineItem(
         ReceiverWorkOrderLineItem lineItem) {
      boolean added=false;
      ReceiverWorkOrderLineItem result=null;
      
      if (this.lineItems == null) {
         this.lineItems=new ArrayList<ReceiverWorkOrderLineItem>();
      } // END if (this.lineItems == null)
      added=this.lineItems.add(lineItem);
      if (added) {
         result=lineItem;
      } // END if (added)
      
      return result;
   }

   @Override
   public ReceiverWorkOrderLineItem removeLineItem(
         ReceiverWorkOrderLineItem lineItem) {
      boolean removed=false;
      ReceiverWorkOrderLineItem result=null;
      
      removed=this.lineItems.remove(lineItem);
      if (removed) {
         result=lineItem;
      } // END if (this.lineItems.remove(lineItem))
      
      return result;
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
   
   //***** purchaseOrderNumber
   @Override
   public String getPurchaseOrderNumber() {
      return this.purchaseOrderNumber;
   }

   @Override
   public void setPurchaseOrderNumber(String purchaseOrderNumber) {
      this.purchaseOrderNumber=purchaseOrderNumber;
   }

   //***** salesOrderNumber
   @Override
   public String getSalesOrderNumber() {
      return this.salesOrderNumber;
   }

   @Override
   public void setSalesOrderNumber(String salesOrderNumber) {
      this.salesOrderNumber=salesOrderNumber;
   }
}