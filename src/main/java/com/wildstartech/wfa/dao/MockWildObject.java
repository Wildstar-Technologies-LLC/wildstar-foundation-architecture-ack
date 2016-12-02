package com.wildstartech.wfa.dao;

import java.util.Date;

import com.wildstartech.wfa.Localization;
import com.wildstartech.wfa.MockObject;

public class MockWildObject extends MockObject implements WildObject {
   private Date dateCreated=null;
   private Date dateModified=null;
   private String createdBy="";
   private String identifier="";
   private String modifiedBy="";
   
   //***** createdBy
   @Override
   public String getCreatedBy() {
      return this.createdBy;
   }
   
   public void setCreatedBy(String createdBy) {
      this.createdBy=createdBy;
   }

   //***** dateCreated
   @Override
   public Date getDateCreated() {
      return this.dateCreated;
   }
   public void setDateCreated(Date dateCreated) {
      this.dateCreated=dateCreated;
   }

   //***** dateModified
   @Override
   public Date getDateModified() {
      return this.dateModified;
   }
   public void setDateModified(Date dateModified) {
      this.dateModified=dateModified;
   }

   //***** identifier
   @Override
   public String getIdentifier() {
      return this.identifier;
   }
   public void setIdentifier(String identifier) {
      this.identifier=identifier;
   }

   //***** localizedMessage
   @Override
   public String getLocalizedMessage(String resourceId, Object[] params) {
      String bundleBase="";
      String msg="";
      
      msg=Localization.getString(bundleBase, resourceId, params);
      
      return msg;
   }

   //***** modifiedBy
   @Override
   public String getModifiedBy() {
      return this.modifiedBy;
   }
   public void setModifiedBy(String modifiedBy) {
      this.modifiedBy=modifiedBy;
   }

   //***** resourceBundleName
   @Override
   public String getResourceBundleBaseName() {
      return WildObject.RESOURCE_BUNDLE;
   }
}