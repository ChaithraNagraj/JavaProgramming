package com.bridgelabs.fs.datastructureprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Calender2Darray {
	final static Logger logger=Logger.getLogger(Calender2Darray.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		logger.info("enter month");
		int m = InputUtility.intVal();
		logger.info("enter yaer");
		int y = InputUtility.intVal();
		Utility.dispCalender(m, y);
	}
}
