package com.bridgelabs.fs.basicprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class FlipCoin {
	final static Logger logger=Logger.getLogger(FlipCoin.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		logger.info("enter the number of flip");
		int n=InputUtility.intVal();
		double[] HT=Utility.flipcoin(n);
		logger.info(HT[0]);
		logger.info(HT[1]);
	}

}
