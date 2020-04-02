package com.bridgelabs.fs.testbasicprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.basicprograms.Utility;

public class Testharmonic {
    @Test
	public void testharmonic()
	{
    double expected=1.5;
    assertEquals(expected,Utility.sum(2),Math.E);

}
    @Test
	public void testharmonic1()
	{
    double expected=5.3853294714747895;
    assertEquals(expected,Utility.sum(122),Math.E);

}

}
