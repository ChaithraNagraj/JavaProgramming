package com.bridgelabs.fs.functionalprograms;

import org.apache.log4j.Logger;

import com.bridgelabs.fs.customiseexception.RootsNotfoundexception;
import com.bridglabz.utility.InputUtility;

public class Utility {
	static Logger logger = Logger.getLogger(Utility.class);
	
	//@method for 2d array
	public static double[][] readDouble2D()
	{
		int m=InputUtility.intVal();//reads a 2d array of doubles from std inputand reutrns it
		int n=InputUtility.intVal();
		double[][] a=new double[m][n];
		for(int i=0; i<m; i++) {
		 for(int j=0;j<n;j++) {
			 a[i][j]=InputUtility.doubleVal();
		 }
		
		} 
		return a;
		
	}
public static void print(double[][] a) {
	int m=a.length;
	int n=a[0].length;
	System.out.println(m+" "+n);
	for(int i=0; i<m; i++) {
		 for(int j=0;j<n;j++) {
		logger.info(a[i][j]+" ");
    }
		 logger.info(" ");
      }
   }
public static boolean[][] readboolean2D()
{
	int m=InputUtility.intVal();
	int n=InputUtility.intVal();
	boolean[][] a=new boolean[m][n];
	for(int i=0; i<m; i++) {
	 for(int j=0;j<n;j++) {
		 a[i][j]=InputUtility.booleanVal();
	 }
	}
	return a;
	}
public static void print(boolean[][] a) {
	int m=a.length;
	int n=a[0].length;
	logger.info(m+""+n);
	for(int i=0; i<m; i++) {
		 for(int j=0;j<n;j++) {
			 if(a[i][j]) 
				 logger.info("1 ");
			 else
			 logger.info("0 ");
			  }
		 logger.info(" ");
      }
}

//method for triplets
public static int findDistinctTriplets(int b[],int length)//method 1
{
	logger.info(" ");
	int i,j,k,count=0;
	for(i=0;i<length;i++)
	{
		for(j=i+1;j<length;j++)
		{
			for(k=j+1;k<length;k++)
			{
				// printing distinct triples (i, j, k) where a[i] + a[j] + a[k] = 0
				if (b[i] + b[j] + b[k] == 0)
				{
					logger.info(b[i] + " " + b[j] + " " + b[k]);
					count++;
				}
			}
		}
	}
	// return number of distinct triplets (i, j, k) such that a[i] + a[j] + a[k] = 0
	return count;
}
//method for distancejava
   public static double distancefrom(int x, int y) {
	 double dist=Math.sqrt(x*x + y*y);
	   
	return dist;
}
   //method for quadraticjava
   public static double rootsof(int a, int b,int c) throws RootsNotfoundexception {
	   double delta=((b*b)-(4*a*c));
	   double root1,root2;
	   if(delta>0) {
		   
	  
	   root1=(-b+Math.sqrt(delta))/(2*a);
	   root2=(-b-Math.sqrt(delta))/(2*a);
	   logger.info(root1 +" "+ root2 );
	   }
	   else if(delta==0) {
		   root1 =  root2=-b / (2*a);
		   logger.info("root1=root2=" + root1 );
		   
	   }
	   //no real roots
	   else
	   {
	   double realpart= -b/(2*a);
	   double imaginarypart=Math.sqrt(-delta) / (2 * a);
	   logger.info("the roots are=" + realpart + imaginarypart);
	   throw new RootsNotfoundexception();
   }
	   return delta;
} 
   //method for windchill 
   public static double effectivetemp(int t, int v) {
	   if(t>50 && v>120) {
		   double w=35.74+0.6215+(0.4275*t- 35.75)* Math.pow(v, 0.16);
		   logger.info(" effective temperature is"+ w);
	   }
	else
	{
		logger.info("not valid for above absolte temperature");
	
   }
	return v;
   
   }
 
   }
