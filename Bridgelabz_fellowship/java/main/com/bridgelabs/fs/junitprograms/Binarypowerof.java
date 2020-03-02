package com.bridgelabs.fs.junitprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Binarypowerof {
	final static Logger logger = Logger.getLogger(Binarypowerof.class);
    public static void main(String[] args) {
	PropertyConfigurator.configure("src//log4j.properties");
	logger.info("enter the value of x");
	long x=InputUtility.longVal();
	logger.info(Utility.decimalTobinary(x));
}

}
