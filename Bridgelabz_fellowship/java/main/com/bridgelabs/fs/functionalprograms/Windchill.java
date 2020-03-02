package com.bridgelabs.fs.functionalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Windchill {
	final static Logger logger = Logger.getLogger(Windchill.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		
    logger.info("enter the temparature and wind speed");
	int t=InputUtility.intVal();
	int v=InputUtility.intVal();
	//System.out.println(Utility.effectivetemp(t,v));
	Utility.effectivetemp(t,v);
	}
	

}
