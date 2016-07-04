package com.wildstartech.wfa.dao.logistics.ltl;

import java.util.Date;

import com.wildstartech.wfa.logistics.ltl.MockReceiverWorkOrderLineItem;
import com.wildstartech.wfa.logistics.ltl.ReceiverWorkOrderLineItem;

public class TestCaseReceiverWorkOrder1 extends TestCaseReceiverWorkOrderBase {
   public Date dateReceived=new Date();
   
   public TestCaseReceiverWorkOrder1() {
      ReceiverWorkOrderLineItem lineItem=null;
      
      this.setBillOfLadingNumber("BOL1234");
      this.setInboundCarrier("ACME Furniture Purveyors");
      this.setDateReceived(this.dateReceived);
      this.setPurchaseOrderNumber("PO#4321");
      this.setSalesOrderNumber("SO97531");
      this.setShortDescription("Short Description");
      this.setStatusState("New");
      this.setStatusReason("");
      this.setTitle("Receiver Work Order Test Case");
      
      //***** First LineItem
      lineItem=new MockReceiverWorkOrderLineItem();
      lineItem.setDescription("FIRST LINE ITEM");
      addLineItem(lineItem);
      
      //***** Second LineItem
      lineItem=new MockReceiverWorkOrderLineItem();
      lineItem.setDescription("SECOND LINE ITEM");
      addLineItem(lineItem);
      
      //***** Third LineItem
      lineItem=new MockReceiverWorkOrderLineItem();
      lineItem.setDescription("THIRD LINE ITEM");
      addLineItem(lineItem);
   }
}