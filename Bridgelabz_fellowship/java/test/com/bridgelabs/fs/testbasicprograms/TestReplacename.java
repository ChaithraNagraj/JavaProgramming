package com.bridgelabs.fs.testbasicprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabs.fs.basicprograms.Utility;

public class TestReplacename{
	@Test
	public void testreplacename() {
		String expected = "Hello chaithra,how are you";
		assertEquals(expected,Utility.replacestring("chaithra"));
		}
	public void testreplacename1() {
		String expected = "Hello vikram,how are you";
		assertEquals(expected,Utility.replacestring("vikram"));
	}

}
