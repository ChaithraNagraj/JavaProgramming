package com.bridgelabs.fs.testbasicprograms;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import com.bridgelabs.fs.basicprograms.Utility;

public class Testpoweroftwo {
	@Test
	public void checking() {
		int expected []= new int[] {2,4,8};
		assertArrayEquals(expected,Utility.powerof(3));
	}

}
