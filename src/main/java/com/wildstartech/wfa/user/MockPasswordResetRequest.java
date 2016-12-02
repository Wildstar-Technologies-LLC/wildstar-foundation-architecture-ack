package com.wildstartech.wfa.user;

import java.net.InetAddress;
import java.util.Date;

import com.wildstartech.wfa.MockObject;

public class MockPasswordResetRequest extends MockObject implements PasswordResetRequest {
   private Date dateSubmitted=null;
   private Date expirationDate=null;
   private InetAddress addressOfRequest=null;
   private String userName=null;
   
   /**
    * Default, no-argument constructor.
    */
   public MockPasswordResetRequest() {
      
   }
   
   public MockPasswordResetRequest(Date dateSubmitted, 
         Date expirationDate, 
         String addressOfRequest, 
         String userName) {
      setAddressOfRequest(addressOfRequest);
      setDateSubmitted(dateSubmitted);
      setExpirationDate(expirationDate);
      try {
         setUserName(userName);
      } catch (UserNameTooLongException ex) {
         ex.printStackTrace(System.err);
      } // END try/catch
   }
   @Override
   public Date getDateSubmitted() {
      return this.dateSubmitted;
   }

   @Override
   public void setDateSubmitted(Date submitDate) {
      this.dateSubmitted=submitDate;
   }

   @Override
   public Date getExpirationDate() {
      return this.expirationDate;
   }

   @Override
   public void setExpirationDate(Date expirationDate) {
      this.expirationDate=expirationDate;
   }

   @Override
   public InetAddress getAddressOfRequest() {
      return this.addressOfRequest;
   }

   @Override
   public void setAddressOfRequest(InetAddress address) {
      this.addressOfRequest=address;
   }
   
   public void setAddressOfRequest(String address) {
       
   }

   @Override
   public String getUserName() {
      return this.userName;
   }

   @Override
   public void setUserName(String userName) throws UserNameTooLongException {
      this.userName=userName;

   }

}
