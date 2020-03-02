package com.bridgelabs.fs.functionalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabs.fs.customiseexception.RootsNotfoundexception;
import com.bridglabz.utility.InputUtility;

public class Quadratic {
	final static Logger logger=Logger.getLogger(Quadratic.class);
public static void main(String[] args) {
	PropertyConfigurator.configure("src//log4j.properties");
	logger.info("enter the values of a, b, c ");
	int a=InputUtility.intVal();
	int b=InputUtility.intVal();
	int c=InputUtility.intVal();
    try {
	//Utility.rootsof(a,b,c);//it will return only the root values
    logger.info(Utility.rootsof(a,b,c));
}
    catch(RootsNotfoundexception e) {
    	e.printStackTrace();
    	
    }
    logger.info("exception handles and now executing below lines");
    logger.info("hi....");
    }
    }

