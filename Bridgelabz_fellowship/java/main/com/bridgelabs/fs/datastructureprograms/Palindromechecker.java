package com.bridgelabs.fs.datastructureprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Palindromechecker {
	final static Logger logger=Logger.getLogger(Palindromechecker.class);
   public static void main(String[] args) {
	PropertyConfigurator.configure("src//log4j.properties");
	logger.info(" enter the string to check for the palindrome");
	String s=InputUtility.stringVal();
	Utility.ispalindrome(s);
}
	
}
