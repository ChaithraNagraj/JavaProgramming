package com.bridgelabs.fs.testbasicprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.customiseexception.LeapyearException;
import com.bridgelabs.fs.basicprograms.Utility;

public class Testleapyear {
	@Test

	public void checkingfortrue()throws LeapyearException{
		boolean expected=true;
		assertEquals(expected,Utility.checkyear(2020));
	}
	
   @Test
	public void checkingforfalse() throws LeapyearException {
		boolean expected=false;
		assertEquals(expected,Utility.checkyear(2018));
}
@Test(expected=LeapyearException.class)
public void testException()throws LeapyearException {
	Utility.checkyear(1234);
	}
		
	}