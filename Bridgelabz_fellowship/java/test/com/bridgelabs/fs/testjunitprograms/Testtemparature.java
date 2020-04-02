package com.bridgelabs.fs.testjunitprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.junitprograms.Utility;

public class Testtemparature {
	@Test
	public void testtemparaturefahrenheit() {
		double expected=251.6;
		assertEquals(expected,Utility.tempinFahrenheit(122),Math.E);
	}
	
	@Test
	public void testtemparaturecelsius() {
		double expected=667.7777777777778;
		assertEquals(expected,Utility.tempinCelsius(1234),Math.E);
	}
	
}
