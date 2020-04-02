package com.bridgelabs.fs.testlogicalprograms;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.bridgelabs.fs.logicalprograms.Utility;

public class Testcouponnumber {
	@Test
	public void testcouponnumber() {
		int expected=27;
		assertEquals(expected,Utility.collect(12));
	}
	/*@Test
	public void testcouponnumber1() {
		int expected=21;
		assertEquals(expected,Utility.collect(11));
	}*/
	}

