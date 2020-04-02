package com.bridgelabs.fs.testjunitprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.junitprograms.Utility;

public class Testbinarypower {
	@Test
	public void testbinarypower() {
		int expected=0;
		assertEquals(expected,Utility.decimalTobinary(102));
	}
	@Test
	public void testbinarypower1() {
		int expected=0;
		assertEquals(expected,Utility.decimalTobinary(1234));
	}

}
