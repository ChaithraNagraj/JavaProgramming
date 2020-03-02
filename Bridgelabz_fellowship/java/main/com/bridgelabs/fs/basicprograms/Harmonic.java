package com.bridgelabs.fs.basicprograms;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Harmonic {
	final static Logger logger = Logger.getLogger(Harmonic.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		logger.info("enter the n value");
		int n=InputUtility.intVal();
		logger.info(Utility.sum(n));
	}

}
