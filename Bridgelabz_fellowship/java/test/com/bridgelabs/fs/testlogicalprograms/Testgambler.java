package com.bridgelabs.fs.testlogicalprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.logicalprograms.Utility;

public class Testgambler {
	@Test
	public void testgambler() {
		int expected = 0;
		assertEquals(expected,Utility.Gamblerwin(122, 2,3));
	}
	@Test
	public void testgambler1() {
		int expected = 0;
		assertEquals(expected,Utility.Gamblerwin(123, 2,1));
	}

}
