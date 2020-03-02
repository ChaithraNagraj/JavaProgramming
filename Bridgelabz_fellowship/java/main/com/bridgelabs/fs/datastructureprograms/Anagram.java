package com.bridgelabs.fs.datastructureprograms;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Anagram extends Primenumber  {
	final static Logger logger = Logger.getLogger(Primenumber.class);
	public static boolean isAnagram(String s1, String s2)
    {
		//Primenumber a=new Primenumber();
       logger.info("enter the number of rows");
       int m=InputUtility.intVal();
		int n=InputUtility.intVal();
		//Removing all white spaces from s1 and s2
		int[][] anagram=primenumber2d(m, n);
		String[] strArray = new String[anagram.length];
		for (int i = 0; i < anagram.length; i++) {
			
			strArray[i] = String.valueOf(anagram[i]);

		logger.info(Arrays.toString(strArray));
	}
	      boolean status = true;
 
		if(strArray.length != anagram.length)
		{
		    //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
		    status = false;
		}
		else
		{
		    //Changing the case of characters of both copyOfs1 and copyOfs2 and converting them to char array
		    //char[] s1Array = a1.toLowerCase().toCharArray();
		    //char[] s2Array = a2.toLowerCase().toCharArray();
		    
		    //Sorting both s1Array and s2Array
		    Arrays.sort(strArray);
		    Arrays.sort(anagram);
		    
		    //Checking whether s1Array and s2Array are equal
		    status = Arrays.equals(strArray, anagram);
		}
		
        //Output
		if(status)
		{
		    logger.info(strArray+" and "+anagram+" are Anagrams");
		}
		else
		{
		logger.info(strArray+" and "+anagram+" are not Anagrams");
		}
		return status;
    }
	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		//Anagram a=new Anagram();
		isAnagram(null, null);
		System.out.println();
	}
}
	