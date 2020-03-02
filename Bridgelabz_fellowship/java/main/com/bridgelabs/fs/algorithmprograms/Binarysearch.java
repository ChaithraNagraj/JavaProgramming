package com.bridgelabs.fs.algorithmprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Binarysearch {
	final static Logger logger = Logger.getLogger(Binarysearch.class);
    public static void main(String []args) 
    {
		PropertyConfigurator.configure("src//log4j.properties");
        String[] arr = { "vikram", "chaithra", "archana", "harshith"}; 
        String x = "chaithra"; 
        int result =Utility.binarySearch(arr, x); 
  
        if (result == -1) 
            logger.info("Element not present"); 
        else
            logger.info("Element found at "+ "index " + result); 
    } 
} 


