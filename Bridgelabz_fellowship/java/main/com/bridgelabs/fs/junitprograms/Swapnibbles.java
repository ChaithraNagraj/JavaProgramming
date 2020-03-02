package com.bridgelabs.fs.junitprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Swapnibbles {
	final static Logger logger = Logger.getLogger(Swapnibbles.class);
     	public static void main(String[] args) {
    	PropertyConfigurator.configure("src//log4j.properties");
		logger.info("enter the value");
		int x=InputUtility.intVal();
	    logger.info( "the decimal value is"+" "+Utility.swapNibbles(x)); 
    }

}
