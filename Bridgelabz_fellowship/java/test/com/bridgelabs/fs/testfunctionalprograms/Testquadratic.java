package com.bridgelabs.fs.testfunctionalprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.functionalprograms.Utility;
import com.bridgelabs.fs.customiseexception.RootsNotfoundexception;

public class Testquadratic {
	@Test(expected=RootsNotfoundexception.class)

	public void testException() throws RootsNotfoundexception {
		Utility.rootsof(3,2,3);
		
	}
	@Test
	public void testquadratic() throws RootsNotfoundexception {
	int expected=1;
	assertEquals(expected,Utility.rootsof(2,5,3),Math.E);
	}

}
