package com.bridgelabs.fs.junitprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabs.fs.customiseexception.Squarerootcanotbefound;
import com.bridglabz.utility.InputUtility;

public class Squareroot {
	final static Logger logger = Logger.getLogger(Squareroot.class);
        public static void main(String[] args) throws Squarerootcanotbefound {
		PropertyConfigurator.configure("src//log4j.properties");
        logger.info("  enter the c value");
		double c=InputUtility.doubleVal();
		try {
			logger.info(" the estimated root is"+ " "+ Utility.SqrtIs(c));
		}
		catch(Squarerootcanotbefound e) {
			e.printStackTrace();
		}
		logger.info("exception handles and now executing below lines");
	    logger.info("hi....");
		}
}
        