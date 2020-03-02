package com.bridgelabs.fs.algorithmprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Insertionsort {
	final static Logger logger = Logger.getLogger(Insertionsort.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		logger.info("enter the n value");
		int n=InputUtility.intVal();
		logger.info("enter the words to print");
		String array[]=new String[n];
		Utility.ArraytoSort(n,array);
	}

}
