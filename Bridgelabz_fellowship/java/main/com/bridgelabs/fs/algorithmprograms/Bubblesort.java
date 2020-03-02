package com.bridgelabs.fs.algorithmprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Bubblesort {
	final static Logger logger = Logger.getLogger(Bubblesort.class);
public static void main(String[] args) {
	PropertyConfigurator.configure("src//log4j.properties");
	logger.info(" enter the total number of integer you want sort");
	int n=InputUtility.intVal();
	logger.info("enter the integers you want to sort");
	int a[]=new int[n];
    Utility.sortedInteger(n,a);

}
}
