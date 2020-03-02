package com.bridgelabs.fs.junitprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabs.fs.customiseexception.DayNotfoundexception;
import com.bridglabz.utility.InputUtility;

public class Dayofweek {
	final static Logger logger = Logger.getLogger(Dayofweek.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
        logger.info("month,day,year");
		int m=InputUtility.intVal();
		int d=InputUtility.intVal();
		int y=InputUtility.intVal();
		try {
			logger.info(Utility.Dayis(m, y, d));
		}
		catch(DayNotfoundexception e){
			e.printStackTrace();
		}
			logger.info("exception handeled");
			logger.info("hello");
	}
}