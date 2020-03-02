package com.bridgelabs.fs.functionalprograms;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Distance {
	final static Logger logger = Logger.getLogger(Distance.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src/log4j.properties");
		logger.info("enter the x value");
	int x=InputUtility.intVal();
	logger.info("enter the y value");
	int y=InputUtility.intVal();
	
 logger.info("distance from (0,0)to the point (x,y)is = " + Utility.distancefrom(x,y));
}
}
	
