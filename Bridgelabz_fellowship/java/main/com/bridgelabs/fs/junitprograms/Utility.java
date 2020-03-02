package com.bridgelabs.fs.junitprograms;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bridgelabs.fs.customiseexception.DayNotfoundexception;
import com.bridgelabs.fs.customiseexception.Moneynotvalidexception;
import com.bridgelabs.fs.customiseexception.Squarerootcanotbefound;

public class Utility {
	static Logger logger = Logger.getLogger(Utility.class);
	//`method for vending machine
	static int i=0;
	static int total=0;
	public static int[] notes= {1000,500,100,50,10,5,2,1};
	static int Money;
	//functions for calling notes
	
	public static int calculation(int Money,int[]notes) throws Moneynotvalidexception
	{
	//calling calculatefuction
		int rem;
		if(Money==0)
		{
			return-1;
		}
		else  {
			if(Money>=notes[i])
			{
				int calNotes=Money/notes[i];
				rem=Money%notes[i];
				Money=rem;
				total+=calNotes;
				logger.info(notes[i]+"notes---->"+calNotes);
				}
			i++;
			 calculation(Money,notes);
			return total;
		}
	
	}
	
//@method for dayofweek
	
	public static int Dayis (int m,int y, int d) throws DayNotfoundexception{
		if(m<1 || m>12) 
		{
			if(y<1000 || y>10000) {
				
			if(d<0 || d>31) {
				throw new DayNotfoundexception("enter the valid date");
		  }	
	  }
    }
		else {
			int y0 = y - (14 - m) / 12;
	        int x = y0 + y0/4 - y0/100 + y0/400;
	        int m0 = m + 12 * ((14 - m) / 12) - 2;
	        int d0 = (d + x + (31*m0)/12) % 7;
				//System.out.println(d0);//it prints which day in means 0 is sunday and so on
			return d0;
			}
		return 0;
 }
	
	
//@method for tempconverstion
	public static double tempinFahrenheit(double c) {
		double f=(c * 9/5) + 32 ;
		return f;
	}
	public static double tempinCelsius(double f) {
		double c=(f-32) * 5/9 ;
		return c;
	}
	
//@method for monthlyPayment 
	public static double Mothlypaymentis(double P, double Y, double R) 
	//p= principal loan amount
	// R= per cent interest compounded monthly
	//Y years to pay 
	{
		R=R/(12*100); 
	 
    Y=Y*12; 
        
    double emi= (P*R*Math.pow(1+R,Y))/(Math.pow(1+R,Y)-1);
  
    
	return emi;	
		
	}

//@method for finding sqrt in Newton's method
	
	public static double SqrtIs(double c) throws Squarerootcanotbefound {
		double epsilon = 1.0e-15;  // relative error tolerance
        double t = c;              // estimate of the square root of c
        if (Math.abs(t - c/t) < epsilon*t) {
        	throw new Squarerootcanotbefound("roots canot be found");
        }
        // repeatedly apply Newton update step until desired precision is achieved
       // while (Math.abs(t - c/t) > epsilon*t) {
        else
        {
            t = (c/t + t) / 2.0;
        }

        // print out the estimate of the square root of c
		return t;
	}
	
//@method for decimal to binary
	public static int decimalTobinary(long x) {
		{ 
		    ArrayList<Integer> v = new ArrayList<Integer>(); 
		      
		    // Convert decimal number to 
		    // its binary equivalent 
		    logger.info("decimalTobinary for "+x+" : "); 
		    while (x > 0)  
		    { 
		        v.add((int)x % 2); 
		        x = x / 2; 
		    } 
		  
		    // Displaying the output when 
		    // the bit is '1' in binary 
		    // equivalent of number. 
		    for (int i = 0; i < v.size(); i++)  
		    { 
		        if (v.get(i) == 1)  
		        { 
		        System.out.print(i); 
		            if (i != v.size() - 1) 
		            System.out.print( ", "); 
		        } 
		    } 
		logger.info(" "); 
		}
		return 0;	
	}
	
//@method swapnubbles
	public static int swapNibbles(int x) 
	{ 
	    return ((x & 0x0F) << 4 | (x & 0xF0) >> 4); 
	} 
	
	
	}