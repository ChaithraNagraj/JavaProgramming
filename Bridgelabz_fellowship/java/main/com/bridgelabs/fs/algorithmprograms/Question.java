package com.bridgelabs.fs.algorithmprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Question {
	final static Logger logger = Logger.getLogger(Question.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		int k=InputUtility.intVal();
		logger.info(" enter the k value");
        int n = (int) Math.pow(2, k);
        System.out.printf("Think of an integer between %d and %d"+ 0, n-1);
        Utility.search(0, n);
    }

}
