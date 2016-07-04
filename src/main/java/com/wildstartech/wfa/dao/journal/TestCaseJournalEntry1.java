package com.wildstartech.wfa.dao.journal;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.wildstartech.wfa.journal.MockJournalEntry;

public class TestCaseJournalEntry1 extends MockJournalEntry {
	
	public TestCaseJournalEntry1() {
		Calendar calendar=null;
		Date acceptableEntryDate=null;
		
		// Let's use April 7, 2008 10:13 AM CST as the test date
	    calendar=new GregorianCalendar();
	    calendar.set(Calendar.YEAR, 2008);
	    calendar.set(Calendar.DATE, 7);
	    calendar.set(Calendar.MONTH, Calendar.APRIL);
	    calendar.set(Calendar.DST_OFFSET, -5);
	    calendar.set(Calendar.HOUR,10);
	    calendar.set(Calendar.MINUTE, 13);
	    calendar.set(Calendar.SECOND,0);
	    calendar.set(Calendar.AM_PM, Calendar.AM);
	    acceptableEntryDate=calendar.getTime();
	    
	    setCategory("Acceptable Category");
	    setDescription("Acceptable Description");
	    setEntryDate(acceptableEntryDate);
	    setContent("This is going to be acceptable content.");	    
	}
}