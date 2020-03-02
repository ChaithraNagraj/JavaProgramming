package com.bridgelabs.fs.junitprograms;

import com.bridglabz.utility.InputUtility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabs.fs.customiseexception.Moneynotvalidexception;
import com.bridgelabs.fs.junitprograms.Utility;
public class Vendingmachine {
	final static Logger logger = Logger.getLogger(Vendingmachine.class);
	//private static int[] notes;

	public static void main(String[] args) throws Moneynotvalidexception {
		PropertyConfigurator.configure("src//log4j.properties");
		logger.info("enter the amount: ");
		int Money=InputUtility.intVal();
		int[] notes= {1000,500,100,50,10,5,2,1};
		try {
		logger.info(Utility.calculation(Money,notes));
		}
		catch(Moneynotvalidexception e){
			e.printStackTrace();}
		logger.info("exceptions handled");
		logger.info(" hiii..");	
	}	
	}
