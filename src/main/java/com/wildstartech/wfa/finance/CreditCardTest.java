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
package com.wildstartech.wfa.finance;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wildstartech.wfa.dao.finance.CreditCardDAO;
import com.wildstartech.wfa.dao.finance.CreditCardDAOFactory;
import com.wildstartech.wfa.finance.CreditCard;

public class CreditCardTest {
   CreditCard creditCard = null;   
   CreditCard referenceCard=SampleCreditCardData.amex[0];
   
   /**
    * Create an instance of the {@code CreditCard} which will be used for the
    * rest of testing.
    */
   @BeforeClass
   public void createInstance() {
      CreditCardDAO dao = null;
      CreditCardDAOFactory factory = null;

      factory = new CreditCardDAOFactory();
      dao = factory.getDAO();
      this.creditCard = dao.create();
   }
   
   @Test
   public void accountNumber() {
      String accountNumber=null;
      String readAccountNumber=null;

      accountNumber=this.referenceCard.getAccountNumber();
      
      this.creditCard.setAccountNumber(accountNumber);
      readAccountNumber=this.creditCard.getAccountNumber();
      
      assert readAccountNumber != null;
      assert readAccountNumber.equals(accountNumber);
   }
   
   @Test
   public void brandName() {
      String brandName=null;
      String readBrandName=null;
      
      brandName=this.referenceCard.getBrandName();
      
      this.creditCard.setBrandName(brandName);
      readBrandName=this.creditCard.getBrandName();
      
      assert readBrandName != null;
      assert readBrandName.equals(brandName);
   }
   
   @Test
   public void issuingBankName() {
      String issuingBankName=null;
      String readIssuingBankName=null;
      
      issuingBankName=this.referenceCard.getIssuingBankName();
      
      this.creditCard.setIssuingBankName(issuingBankName);
      readIssuingBankName=this.creditCard.getIssuingBankName();
      
      assert readIssuingBankName != null;
      assert readIssuingBankName.equals(issuingBankName);
   }
   
   @Test
   public void cardHolderName() {
      String cardHolderName=null;
      String readCardHolderName=null;
      
      cardHolderName=this.referenceCard.getCardHolderName();
      
      this.creditCard.setCardHolderName(cardHolderName);
      readCardHolderName=this.creditCard.getCardHolderName();
      
      assert readCardHolderName != null;
      assert readCardHolderName.equals(cardHolderName);
   }
   
   @Test
   public void verification() {
      String verification=null;
      String readVerification=null;
      
      verification=this.referenceCard.getVerification();
      
      this.creditCard.setVerification(verification);
      readVerification=this.creditCard.getVerification();
      
      assert readVerification != null;
      assert readVerification.equals(verification);
   }   
}