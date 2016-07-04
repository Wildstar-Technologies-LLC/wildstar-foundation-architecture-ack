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
package com.wildstartech.wfa.journal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import com.wildstartech.wfa.MockObject;
import com.wildstartech.wfa.journal.JournalEntry;

public class MockJournalEntry extends MockObject implements JournalEntry {
	private Date entryDate=null;
	private MimeType mimeType=null;
	private String category = "";
	private String content="";
	private String description="";
	
	/**
	 * Default, no-argument constructor.
	 */
	public MockJournalEntry() {
		this.category="";
		this.description="";
		this.content="";
		try {
			this.mimeType=new MimeType("text","plain");
		} catch (MimeTypeParseException ex) {
			ex.printStackTrace(System.err);
		} // END try/catch
	}
	
	/**
	 * 
	 * @param entry
	 */
	public MockJournalEntry(JournalEntry entry) {
		if (entry != null) {
			this.entryDate=entry.getEntryDate();
			this.category=entry.getCategory();
			this.content=entry.getContent();
			this.description=entry.getDescription();
			this.mimeType=entry.getMimeType();
		} // END if (entry != null)
	}

	@Override
	public String getCategory() {
		return this.category;
	}

	@Override
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public InputStream getContentAsInputStream() {
		return new ByteArrayInputStream(this.content.getBytes());
	}

	@Override
	public OutputStream getContentAsOutputStream() {
		ByteArrayOutputStream out=null;
		return null;
	}

	@Override
	public String getContent() {
		return this.content;
	}

	@Override
	public void setContent(String content) {
		this.content=content;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description=description;
	}

	@Override
	public Date getEntryDate() {
		return this.entryDate;
	}

	@Override
	public void setEntryDate(Date entryDate) {
		this.entryDate=entryDate;
	}

	@Override
	public void setMimeType(MimeType mimeType) {
		this.mimeType=mimeType;
	}

	@Override
	public MimeType getMimeType() {
		return this.mimeType;
	}
}