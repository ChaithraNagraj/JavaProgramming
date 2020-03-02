package com.bridgelabs.fs.functionalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Triplets {
	final static Logger logger = Logger.getLogger(Triplets.class);
	public static  void main(String[] args)
	{
		PropertyConfigurator.configure("src//log4j.properties");
		//InputUtility u1=new InputUtility();
		logger.info("");

		//enter the array size
		logger.info("Enter Size of Array :");
		int size=InputUtility.intVal();
		int arr[]=new int [size];//create array & read values one by one

		for(int i=0;i<arr.length;i++)
		{
			logger.info("Enter "+(i+1)+" Value :");
			arr[i]=InputUtility.intVal();
		}

		//Triplets t1=new Triplets();
		//int sum=t1.findDistinctTriplets(arr,size);//pass the arguments to method 1
		//Utility.findDistinctTriplets(arr,size);=it prints only triplets
		logger.info(Utility.findDistinctTriplets(arr,size));//this will give triplets and how many triplets u got
			//System.out.println("No.of Tripltes : "+sum);
	}
}
