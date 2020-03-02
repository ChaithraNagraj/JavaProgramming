package com.bridgelabs.fs.datastructureprograms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class Primenumber {
	final static Logger logger = Logger.getLogger(Primenumber.class);

			// create object of Prime number matrix.
				//Primenumber ob = new Primenumber();

				// create object of buffer stream.
				@SuppressWarnings("unused")
				public static int[][] primenumber2d(int m, int n){
					// 2D array for storing 'm*n' prime numbers
				int A[][]=new int[m][n];
				
				// 1D array for storing 'm*n' prime numbers
				int B[] = new int [m*n];

				// For taking natural numbers
				int i = 0, j;
				int k = 1; 

				// for iD Array.
				while(i < m*n)
				{
					if(Utility.isPrime(k)==true)
					{
						B[i] = k;
						i++;
					}
					k++;
				}

				// for 2D Array.
				int x = 0;
				for(i=0; i<m; i++)
				{
					for(j=0; j<n; j++)
					{
						A[i][j] = B[x];
						x++;
					}
				}

				// printing the result in 2D Array.
				logger.info("The Final Array is : ");
				for(i=0; i<m; i++)
				{
					for(j=0; j<n; j++)
					{
					logger.info(A[i][j]+"\t");
					}
					logger.info(" ");
				}
				return A;
				
			}
		public static void main(String[] args) {
			PropertyConfigurator.configure("src//log4j.properties");
			@SuppressWarnings("unused")
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			// enter the number of rows and column.
			logger.info("Enter the number of rows : ");
			int m=InputUtility.intVal();

			logger.info("Enter the number of columns : ");
			int n=InputUtility.intVal();
			primenumber2d( m,  n);
			
		}
}
