package com.bridgelabs.fs.testbasicprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.basicprograms.Utility;

public class Testflipcoin {
	@Test
	public void checking() {
		double expected []= new double[] {80.0, 20.0};
		assertEquals(expected,Utility.flipcoin(5));
	}

}
