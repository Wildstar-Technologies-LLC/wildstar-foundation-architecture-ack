package com.wildstartech.wfa.user;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.wildstartech.wfa.user.UserNameTooLongException;

public class TestCasePasswordResetRequest1 extends MockPasswordResetRequest {
   private static String _CLASS=TestCasePasswordResetRequest1.class.getName();
   private static Logger logger=Logger.getLogger(_CLASS);
   
   public TestCasePasswordResetRequest1() {
      logger.entering(_CLASS, "TestCasePasswordResetRequest1()");
      Calendar calendar=null;
      InetAddress address=null;
      
      try {
         calendar=new GregorianCalendar();
         calendar.add(Calendar.HOUR, 3);
         address=InetAddress.getByName("127.0.0.1");
         
         setAddressOfRequest(address);
         setDateSubmitted(new Date());
         setExpirationDate(calendar.getTime());
         setUserName("test.user@foo.com");
      } catch (UnknownHostException ex) {
         logger.log(Level.SEVERE, 
               "UnknownHostException Shouldn't Happen", 
               ex);
      } catch (UserNameTooLongException ex) {
         logger.log(Level.SEVERE,
               "UserNameTooLongException Shouldn't Happen",
               ex);      
      } // END try/catch
      logger.exiting(_CLASS, "TestCasePasswordResetRequest1()");
   }
}