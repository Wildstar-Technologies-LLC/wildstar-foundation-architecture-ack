package com.wildstartech.wfa.user;

public class TestCaseUser1 extends MockUser {
   public TestCaseUser1() {
      try {
         this.setName("test.user@foo.com");
         this.setPassword("mysuperpassword");
      } catch (UserNameTooLongException ex) {
         ex.printStackTrace();
      } catch (PasswordTooLongException ex) {
         ex.printStackTrace();
      }      
   }
}