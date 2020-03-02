package com.bridgelabs.fs.junitprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class MonthlyPayment {
	final static Logger logger = Logger.getLogger(MonthlyPayment.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		logger.info("enter the rate, year, percentage of interest");
		double P=InputUtility.doubleVal();
		double Y=InputUtility.doubleVal();
		double R=InputUtility.doubleVal();
	logger.info("the emi is or the pay is"+" "+ Utility.Mothlypaymentis(P,Y,R) );
	}

}
