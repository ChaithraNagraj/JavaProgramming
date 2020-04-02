package com.bridgelabs.fs.testlogicalprograms;

import org.junit.Test;

import com.bridgelabs.fs.customiseexception.Timeinvalidexception;
import com.bridgelabs.fs.logicalprograms.Utility;


public class Teststopwatch {
	@Test(expected=Timeinvalidexception.class)
	public void testException() throws Timeinvalidexception{
		Utility.getElapsedTime(0000000000l);
	}

}
