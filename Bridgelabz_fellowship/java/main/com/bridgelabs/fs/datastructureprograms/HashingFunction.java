package com.bridgelabs.fs.datastructureprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HashingFunction {
	final static Logger logger=Logger.getLogger(HashingFunction.class);
	  	public static void main(String[] args) {
			PropertyConfigurator.configure("src//log4j.properties");
	  		Utility.HashingFunction();
		}	
	  	}
