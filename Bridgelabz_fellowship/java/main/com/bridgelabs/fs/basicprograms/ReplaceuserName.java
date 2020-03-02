package com.bridgelabs.fs.basicprograms;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

import org.apache.log4j.Logger;
public class ReplaceuserName {
final static Logger logger = Logger.getLogger(ReplaceuserName.class);
	public static void main(String[] args) {
		try {
		PropertyConfigurator.configure("src//log4j.properties");
		
		logger.info("Hello user,how are you");
		
		logger.info("Enter the name you want to replace ");
		String str1=InputUtility.inputstring();
		
		logger.info(Utility.replacestring(str1));
		}
		finally{
		System.out.println("this is not a given name");	
		}
		}
	}


