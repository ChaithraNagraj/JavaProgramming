package com.bridgelabs.fs.basicprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Poweroftwo {
	 final static Logger logger=Logger.getLogger(Poweroftwo.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		logger.info("enter the n value");
        int n=InputUtility.intVal();
        int [] b=Utility.powerof(n);
        for(int i=0;i<b.length; i++) {
        	logger.info("2power"+" "+(i+1)+" "+b[i]);
        }
	  // logger.info(Utility.powerof(n));
      //  Utility.powerof(n);
	}
	}
