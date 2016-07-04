package com.wildstartech.wfa.dao.logistics;

import org.testng.annotations.Test;

import com.wildstartech.wfa.logistics.WarehouseLocation;

public class WarehouseLocationDAOTest {
   
   @Test
   public void testCreate() {
      WarehouseLocation location=null;
      WarehouseLocationDAO dao=null;
      WarehouseLocationDAOFactory factory=null;
      
      factory=new WarehouseLocationDAOFactory();
      dao=factory.getDAO();
      location=dao.create();
      assert location !=null;
      assert location instanceof PersistentWarehouseLocation;
   }

}