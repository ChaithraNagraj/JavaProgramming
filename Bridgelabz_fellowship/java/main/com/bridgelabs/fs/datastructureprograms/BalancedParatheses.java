package com.bridgelabs.fs.datastructureprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class BalancedParatheses {
	final static Logger logger=Logger.getLogger(BalancedParatheses.class);
	public static void main(String[] args) 
	{		
		PropertyConfigurator.configure("src//log4j.properties");
		logger.info("enter the string");
		String s=InputUtility.stringVal();
		String result = (Utility.check(s)) ? "Balanced" : "Not Balanced";
		logger.info(result);
	}
	}

