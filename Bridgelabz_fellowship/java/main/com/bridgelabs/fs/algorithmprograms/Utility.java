package com.bridgelabs.fs.algorithmprograms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.apache.log4j.Logger;

import com.bridglabz.utility.InputUtility;

public class Utility {
	static Logger logger = Logger.getLogger(Utility.class);

//@method for binary search world list
	
	static int binarySearch(String[] arr, String x) 
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            int res = x.compareTo(arr[m]); 
  
            // Check if x is present at mid 
            if (res == 0) 
                return m; 
  
            
            if (res > 0) //ignore left half
                l = m + 1; 
  
        
            else
                r = m - 1; //it will ignore right half
        } 
  
        return -1; 
    } 
	
//@method for insertion sort
	static int n;
	 static String array[]=new String[n];

	public static int ArraytoSort(int n, String array[]) {
		for(int i=0;i<array.length;i++)
		{
			array[i]=InputUtility.stringVal();
		}
		logger.info(" ");
	       
		//sort string array using Arrays.sort method
		logger.info("Sorted order is: ");
		for(int i=0;i<array.length;i++)
		{
			Arrays.sort(array);
			logger.info(array[i]);
		}
		return n;
	}
	
//@method for Bubble Sort 
	static int a[]=new int[n];
  
	public static int sortedInteger(int n,int a[]) {
		int i,j,temp=0;
		for(i=0;i<a.length;i++)       
		{
		    a[i]=InputUtility.intVal();		//taking input from user
		}
		for(i=0;i<a.length;i++)         //sorting the array
		{
			for(j=i+1;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		logger.info(" ");
		logger.info("The sorted order is:");

		for(i=0;i<a.length;i++)      
		{
		     logger.info(a[i]);//printing the sorted array
		}
		return temp;
	}

//@method for mergesort


   public static void mergeSort(int[] A) {
        if (A.length > 1) {
            int q = A.length/2;
            int[] leftArray = Arrays.copyOfRange(A, 0, q);
            int[] rightArray = Arrays.copyOfRange(A,q+1,A.length);
            mergeSort(leftArray);
            mergeSort(rightArray);
            A = merge(leftArray,rightArray);
        }
    }

    static int[] merge(int[] l, int[] r) {
        int totElem = l.length + r.length;
        int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        return a;

    }

    //@method for anagram
    static int NO_OF_CHARS = 256; 
    
    /* function to check whether two strings 
    are anagram of each other */
    static boolean areAnagram(char str1[], char str2[]) 
    { 
        int count1[] = new int[NO_OF_CHARS]; //createting two arrays two comapre and initializing
        Arrays.fill(count1, 0); 
        int count2[] = new int[NO_OF_CHARS]; 
        Arrays.fill(count2, 0); 
        int i; 
  
        for (i = 0; i < str1.length && i < str2.length; //for each char input increment the corresponding count 
             i++) { 
            count1[str1[i]]++; 
            count2[str2[i]]++; 
        } 
  
        if (str1.length != str2.length) //both thje string should be same length
            return false; 
  
        for (i = 0; i < NO_OF_CHARS; i++) //compare two arrays
            if (count1[i] != count2[i]) 
                return false; 
  
        return true; 
    } 
   
  //@method for prime numbers
    
    public static void primenumbersAre() {
    	
    int i =0;
    int num =0;
    String  primeNumbers = "";//initialize empty string

    for (i = 1; i <= 100; i++)         
    { 		  	  
       int counter=0; 	  
       for(num =i; num>=1; num--)
	  {
          if(i%num==0)
	     {
		counter = counter + 1;
	     }
	  }
	  if (counter ==2)
	  {
	     //Appended the Prime number to the String
	     primeNumbers = primeNumbers + i + " ";
	  }	
    }	
    logger.info("Prime numbers from 1 to 100 are :");
    logger.info(primeNumbers);
}
 
//method for question
    public static int search(int lo, int hi) {
        if ((hi - lo) == 1)
        	return lo;
        int mid = lo + (hi - lo) / 2;
       System.out.println("less than %d ?" +" "+ mid);
        if (InputUtility.booleanVal()) 
        	return search(lo, mid);
        else                    
        	return search(mid, hi);
    }
    
 //@method for regex 
    
    
    BufferedReader br;
	private final String REGEX_NAME = "<<name>>";
	private final String REGEX_FULLNAME = "<<full name>> ";
	private final String REGEX_MOBILE_NO = "xxxxxxxxxx";
	private final String REGEX_DATE = "12/06/2016";
	
	//constructor to initialize bufferedReader
	public Utility(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	
	
	//Regex pattern matcher match the string and replace the regex pattern with user details.
	
	public String convertString(UserDetails userDetails,String message){
		Pattern p = Pattern.compile(REGEX_NAME);
		Matcher m = p.matcher(message); 
		message = m.replaceAll(userDetails.getfName());

		p = Pattern.compile(REGEX_FULLNAME);
		m = p.matcher(message); 
		message = m.replaceAll(userDetails.getfName()+" "+userDetails.getlName());

		p = Pattern.compile(REGEX_MOBILE_NO);
		m = p.matcher(message); 
		message = m.replaceAll(userDetails.mobileNo());

		p = Pattern.compile(REGEX_DATE);
		m = p.matcher(message); 
		message = m.replaceAll(userDetails.date());

		return message;
	}
	

	public Date printDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try{
			return sdf.parse(date);
		}
		catch(ParseException pe){
			return null;
		}
	}

	//format date object in this format 01/12/2016 
	public String getFormatedDate(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		return sdf.format(date);
	}
	
	
//@method for task complistion



}