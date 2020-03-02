package com.bridgelabs.fs.algorithmprograms;

import java.io.IOException;
import com.bridglabz.utility.InputUtility;

public class Mergesort {

	public static void main(String[] args) throws IOException{
        //BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the array size");
		int arraySize = InputUtility.intVal();
		System.out.println(" enter the array elements");
        int[] arr = new int[arraySize];
        for(int i=0;i<arr.length;i++)
		{
			System.out.println("Enter "+(i+1)+" Value :");
			arr[i]=InputUtility.intVal();
		}
        
       Utility.mergeSort(arr);
       }
}
