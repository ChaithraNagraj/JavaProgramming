package com.bridgelabs.fs.testjunitprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.junitprograms.Utility;

public class Testmonthlypayment {
	@Test
	public void testmonthlypayment() {
		double expected =23.029293570646587;
		assertEquals(expected,Utility.Mothlypaymentis(1000,4,5),Math.E);
	}
	@Test
	public void testmonthlypayment1() {
		double expected =3793.597413068084;
		assertEquals(expected,Utility.Mothlypaymentis(235555,6,5),Math.E);
	}
}
