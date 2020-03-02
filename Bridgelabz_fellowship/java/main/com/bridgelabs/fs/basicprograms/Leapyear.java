package com.bridgelabs.fs.basicprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabs.fs.customiseexception.LeapyearException;
import com.bridglabz.utility.InputUtility;

public class Leapyear {
	final static Logger logger = Logger.getLogger(Leapyear.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		logger.info("enter the year");
		 int year=InputUtility.intVal();
		 //logger.info(Utility.checkyear(year));
		 boolean a=false;
		 try {
			 a=Utility.checkyear(year);
			 if(a==true) {
				 logger.debug("the year"+ " " + year+" "+"is a leapyear");
			 }
			 else
				 logger.debug(" the year"+" "+year+" "+"is a not leapyear");
		 }
		 catch(LeapyearException e) {
			 e.printStackTrace();
			 System.out.println(" hello world");
			 System.out.println("hi");
	}

	}
	}
