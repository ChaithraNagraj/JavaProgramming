package com.bridgelabs.fs.testfunctionalprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.functionalprograms.Utility;

public class Testtriplets {
@Test
public void testtriplets() {
	int expected=3;
		int a[]={0,-1,2,-3,1,0};
				assertEquals(expected,Utility.findDistinctTriplets(a,6));
}

}