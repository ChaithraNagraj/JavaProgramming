package com.bridgelabs.fs.testbasicprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.basicprograms.Utility;

public class Testfactors {
@Test
public void testfactors() {
	int expected=30;
	assertEquals(expected,Utility.factorial(6));
	}
@Test
public void testfactors1() {
	int expected=188790;
	assertEquals(expected,Utility.factorial(435));
	}

}

