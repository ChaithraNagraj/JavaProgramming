package com.bridgelabs.fs.testjunitprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.customiseexception.DayNotfoundexception;
import com.bridgelabs.fs.junitprograms.Utility;

public class TestDayofweek {
@Test
public void testDayofweek() throws DayNotfoundexception {
	int expected=1;
	assertEquals(expected,Utility.Dayis(7,2012,23));
}

@Test(expected=DayNotfoundexception.class)
public void testExceptions() throws DayNotfoundexception {
	Utility.Dayis(13,1000000,32);
}
}
