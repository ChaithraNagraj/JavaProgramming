package com.bridgelabs.fs.testfunctionalprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.functionalprograms.Utility;

public class Testwindchill {
	@Test
	public void testwindchill() {
		double expected=130;
		assertEquals(expected,Utility.effectivetemp(57,130),Math.E);
	}

}
