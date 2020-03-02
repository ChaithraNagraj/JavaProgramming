package com.bridgelabs.fs.logicalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class CouponNumber {
	final static Logger logger = Logger.getLogger(CouponNumber.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");

		logger.info("enter the value a n");
		int n=InputUtility.intVal();
		//Utility.collect(n);
		logger.info(Utility.collect(n));
	  //logger.info(count);
	}

}
