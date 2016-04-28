package com.wildstartech.wfa.finance;

import org.testng.annotations.Test;

import com.wildstartech.wfa.dao.finance.PersistentPaymentCard;

public class PaymentCardTest {
   private PersistentPaymentCard<PaymentCard> paymentCard=null;
   private PaymentCard referenceCard=SampleCreditCardData.amex[0];
   
   
   @Test
   public void accountNumber() {
      String accountNumber=null;
      String readAccountNumber=null;

      accountNumber=this.referenceCard.getAccountNumber();
      
      this.paymentCard.setAccountNumber(accountNumber);
      readAccountNumber=this.paymentCard.getAccountNumber();
      
      assert readAccountNumber != null;
      assert readAccountNumber.equals(accountNumber);
   }
   
   @Test
   public void brandName() {
      String brandName=null;
      String readBrandName=null;
      
      brandName=this.referenceCard.getBrandName();
      
      this.paymentCard.setBrandName(brandName);
      readBrandName=this.paymentCard.getBrandName();
      
      assert readBrandName != null;
      assert readBrandName.equals(brandName);
   }
   
   @Test
   public void issuingBankName() {
      String issuingBankName=null;
      String readIssuingBankName=null;
      
      issuingBankName=this.referenceCard.getIssuingBankName();
      
      this.paymentCard.setIssuingBankName(issuingBankName);
      readIssuingBankName=this.paymentCard.getIssuingBankName();
      
      assert readIssuingBankName != null;
      assert readIssuingBankName.equals(issuingBankName);
   }
}
