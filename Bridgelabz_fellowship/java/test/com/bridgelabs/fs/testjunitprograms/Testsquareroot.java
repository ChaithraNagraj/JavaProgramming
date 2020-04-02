package com.bridgelabs.fs.testjunitprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.customiseexception.Squarerootcanotbefound;
import com.bridgelabs.fs.junitprograms.Utility;

public class Testsquareroot {
@Test
public void testsquareroot() throws Squarerootcanotbefound {
	double expected=6.5;
	assertEquals(expected,Utility.SqrtIs(12),Math.E);
}
@Test
public void testsquareroot1() throws Squarerootcanotbefound {
	double expected=12.0;
	assertEquals(expected,Utility.SqrtIs(23),Math.E);
}
@Test(expected=Squarerootcanotbefound.class)
public void testexception() throws Squarerootcanotbefound{
	Utility.SqrtIs(1);
}
}
