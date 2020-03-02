package com.bridgelabs.fs.logicalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabs.fs.customiseexception.Timeinvalidexception;
import com.bridglabz.utility.InputUtility;

public class Stopwatch {
	final static Logger logger = Logger.getLogger(Stopwatch.class);

		public static void main(String[] args) {
			PropertyConfigurator.configure("src//log4j.properties");

		logger.info("enter the 1 to start the timer");
		int u=InputUtility.intVal();
		//System.out.println("enter the 2 to stop the timer");
		//int u1=InputUtility.intVal();
		try {
		logger.info(Utility.getElapsedTime(u));
		}
		catch(Timeinvalidexception e) {
			e.printStackTrace();
		}
		logger.info("exception handeled");
		logger.info("hello");
		}

}
