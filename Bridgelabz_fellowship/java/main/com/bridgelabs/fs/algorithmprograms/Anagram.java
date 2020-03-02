package com.bridgelabs.fs.algorithmprograms;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabs.fs.algorithmprograms.Utility;
public class Anagram {
	final static Logger logger = Logger.getLogger(Anagram.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		logger.info(" ");
	        char str1[] = ("geeksforgeeks").toCharArray();
	        char str2[] = ("forgeeksgeeks").toCharArray();
	        if (Utility.areAnagram(str1, str2)) 
	            logger.info("The two strings are" + " anagram of each other"); 
	        else
	            logger.info("The two strings are not"+ " anagram of each other"); 
	    } 
	} 
	
