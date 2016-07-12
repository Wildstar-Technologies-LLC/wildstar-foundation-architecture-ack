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

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SampleCreditCardData {

    /* Calculate the expiration date.
    * 
    * To get this date, three years will be added to the current year.
     */
    public static int expirationMonth = 0;
    public static int expirationYear = 0;

    static {
        Calendar calendar = null;
        calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, 3);
        SampleCreditCardData.expirationMonth = calendar.get(Calendar.MONTH) + 1;
        SampleCreditCardData.expirationYear = calendar.get(Calendar.YEAR);
    }

    // American Express
    public static CreditCard[] amex = {
        new TestCaseAmex0005(),
        new TestCaseAmex8431(),
        new TestCaseAmex1000(),
    };
    
    // Australian Bank Card
    public static CreditCard[] austrailianBankCard = {
          new TestCaseAustralianBankCard8250()
    };
    
    // Diners Club
    public static CreditCard[] dinersClub = {
          new TestCaseDinersClub5904(),
          new TestCaseDinersClub3237()
    };
    
    // Discover
    public static CreditCard[] discover = {
        new TestCaseDiscover1117(),
        new TestCaseDiscover9424()
    };

    // JCB
    public static CreditCard[] jcb = {
        new TestCaseJCB0000(),
        new TestCaseJCB0505()
    };
    // MasterCard
    public static CreditCard[] masterCard = {
        new TestCaseMasterCard4444(),
        new TestCaseMasterCard5100()
    };
    // Visa
    public static CreditCard[] visa = {
        new TestCaseVisa1111(),
        new TestCaseVisa1881(),
        new TestCaseVisa2222()
    };
    // Dankort (PBS)
    public static CreditCard[] dankort = {
        new TestCaseDankort4561(),
        new TestCaseDankort3742()        
    };
    // Switch/Solo (Paymentech)
    public static CreditCard[] switchSolo = { new TestCaseSwitchSolo0016() };
}