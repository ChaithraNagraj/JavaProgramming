package com.bridgelabs.fs.testjunitprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.junitprograms.Utility;

public class Testswapnibbles {
	@Test
	public void testswapnibbles() {
		int expected=32;
		assertEquals(expected, Utility.swapNibbles(2));
	}
	@Test
	public void testswapnibbles1() {
		int expected=93;
		assertEquals(expected, Utility.swapNibbles(213));
	}
}
