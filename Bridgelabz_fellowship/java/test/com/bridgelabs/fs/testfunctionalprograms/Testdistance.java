package com.bridgelabs.fs.testfunctionalprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.functionalprograms.Utility;

public class Testdistance {
	@Test
	public void testdistance() {
		double expected=3.605551275463989;
		assertEquals(expected,Utility.distancefrom(2,3),Math.E);
	}
	

}
