package com.bridgelabz.employee.utills;

import java.util.Scanner;

public class InputUtility {
	//final static Logger logger=Logger.getLogger(InputUtility.class);
	private static final Scanner sc = new Scanner(System.in);
    private  static String s1;
	public static String inputstring() {
		s1=sc.nextLine();
		return s1;
	}
	public static int intVal() {
		return sc.nextInt();
	}
	public static float floatVal() {
		return sc.nextFloat();
	}
	public static double doubleVal() {
		return sc.nextDouble();
	}
	public static byte byteVal() {
		return sc.nextByte();
	}
	public static String stringVal() {
		return sc.nextLine();
	}
	public static boolean booleanVal() {
		return sc.nextBoolean();
	}
	public static char charVal() {
		return sc.next().charAt(0);
	}
	public static long longVal() {
		return sc.nextLong();
	}
	
	//Take 1D Array Input
		public static int[] input1DArray(int arraySize){
			int array[]=new int[arraySize];
			for(int i=0;i<arraySize;i++){
				System.out.println("Enter array["+i+"] : ");
				array[i]=intVal();
			}
			return array;
		}

		//Take 1D String Array Input
		public static String[] input1DStringArray(int arraySize){
			String array[]=new String[arraySize];
			for(int i=0;i<arraySize;i++){
				System.out.println("Enter array["+i+"] : ");
				array[i]=stringVal();
			}
			return array;
		}

		//Print 1D array
		public static void print1DArray(int array[]){
			for(int i=0;i<array.length;i++)
			System.out.println(array[i]+" ");
			System.out.println(" ");
		}
		
		//print 1D array String
		public void print1DStringArray(String array[]){
			for(int i=0;i<array.length;i++)
				System.out.println(array[i]+" ");
			System.out.println(" ");
		}

}
