package com.bridgelabs.fs.basicprograms;

import org.apache.log4j.Logger;

import com.bridgelabs.fs.customiseexception.LeapyearException;

public class Utility {
	static Logger logger = Logger.getLogger(Utility.class);

	//replaceuser name
	
	public static String replacestring(String str2) {
	
		String str1;
		str1="Hello user,how are you";
		String str3=str1.replace("user", str2);
		return str3;
	}
	//leapyear
	
	 public static boolean checkyear(int year) throws LeapyearException {
	
		if(year>=1000)
		{
			if(year>=1582 && year<=9999)
		
		{
			
			if(year % 400==0)
		    return true;
		    if(year %100==0)
			return false;
		    if(year %4==0)
			return true;
		    
		}
	
	}
		return false;
	}
 //harmonic
	  public static double sum(int n)
		{
			double i;
			double value=0.0;
			for(i=1;i<=n;i++)
				value=value+1/i;
			logger.info(value);
			return value;
		}
	  //factors
	  public static int factorial(int n) {

	  int fact = 0;
		for(int i=0; i<=n;i++);
		{
			fact=n*(n-1);
			logger.info("factorial of number"+fact);
			return fact;
		}
	  }
	  //power of two
	  public static int[] powerof(int n) {
		  double p=Math.pow(2, n);
		  int power=1;
			int []a=new int[n];
			while(power <p) {
				for(int i=0;i<n;i++) 
				{
				power=2*power;
			a[i]=power;

			}
			}
			return a;
	  	
	  }
	  //flipcoin
	  public static double[] flipcoin(int n) {
		  double heads=0;
		  double tails=0;
		  double[] headtails=new double[2];
		  for(int i=0; i<n; i++) {
		  if(Math.random()>0.5) {
			  heads++;
			  }
		  else
			  tails++;
		  }
		 
	  headtails[0]=(heads/n *100);
	  headtails[1]=(tails/n *100);
	  return headtails;
}
	  
}