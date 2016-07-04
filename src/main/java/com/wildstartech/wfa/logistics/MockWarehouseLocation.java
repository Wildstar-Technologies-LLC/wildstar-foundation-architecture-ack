/*
 * Copyright (c) 2001 - 2016 Wildstar Technologies, LLC.
 *
 * This file is part of Wildstar Foundation Architecture.
 *
 * Wildstar Foundation Architecture is free software: you can redistribute it
 * and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * Wildstar Foundation Architecture is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Wildstar Foundation Architecture.  If not, see 
 * <http://www.gnu.org/licenses/>.
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
 *      Panama City Beach, FL 32413
 *      USA
 *
 *      derek.berube@wildstartech.com
 *      www.wildstartech.com
 */
package com.wildstartech.wfa.logistics;

public class MockWarehouseLocation implements WarehouseLocation {
   
   private String aisle="";
   private String bay="";
   private String level="";
   private String position="";
   
   
   public MockWarehouseLocation() {
      // NO-Op
   }
   
   //***** Utility Methods
   @Override
   public int hashCode() {
   	final int prime = 31;
   	int result = 1;
   	result = prime * result + ((aisle == null) ? 0 : aisle.hashCode());
   	result = prime * result + ((bay == null) ? 0 : bay.hashCode());
   	result = prime * result + ((level == null) ? 0 : level.hashCode());
   	result = prime * result + ((position == null) ? 0 : position.hashCode());
   	return result;
   }

   @Override
   public boolean equals(Object obj) {
   	if (this == obj)
   		return true;
   	if (obj == null)
   		return false;
   	if (getClass() != obj.getClass())
   		return false;
   	MockWarehouseLocation other = (MockWarehouseLocation) obj;
   	if (aisle == null) {
   		if (other.aisle != null)
   			return false;
   	} else if (!aisle.equals(other.aisle))
   		return false;
   	if (bay == null) {
   		if (other.bay != null)
   			return false;
   	} else if (!bay.equals(other.bay))
   		return false;
   	if (level == null) {
   		if (other.level != null)
   			return false;
   	} else if (!level.equals(other.level))
   		return false;
   	if (position == null) {
   		if (other.position != null)
   			return false;
   	} else if (!position.equals(other.position))
   		return false;
   	return true;
   }
   //***** Accessor Methods
   @Override
   public String getAisle() {
      return this.aisle;
   }

   @Override
   public void setAisle(String aisle) {
      this.aisle=aisle;
   }

   @Override
   public String getBay() {
      return this.bay;
   }

   @Override
   public void setBay(String bay) {
      this.bay=bay;
   }

   @Override
   public String getLevel() {
      return this.level;
   }

   @Override
   public void setLevel(String level) {
      this.level=level;
   }

   @Override
   public String getPosition() {
      return this.position;
   }

   @Override
   public void setPosition(String position) {
      this.position=position;
   }
}