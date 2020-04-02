package com.bridgelabs.fs.testjunitprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.customiseexception.Moneynotvalidexception;
import com.bridgelabs.fs.junitprograms.Utility;

public class Testvendingmachine {
	/*@Test(expected=Moneynotvalidexception.class)
	public void testException() throws Moneynotvalidexception 
	{
		int[] notes= {1000,500,100,50,10,5,2,1};
		Utility.calculation(1653,notes);

	}*/
	/*@Test
	public void testvendingmachine()throws Moneynotvalidexception{
		int expected=9;
		assertEquals(expected,Utility.calculation(1423,Utility.notes));
	}
	*/

 @Test
public void testvendingmachine1()throws Moneynotvalidexception{
	int expected=5;
	assertEquals(expected,Utility.calculation(123,Utility.notes));
}
}
