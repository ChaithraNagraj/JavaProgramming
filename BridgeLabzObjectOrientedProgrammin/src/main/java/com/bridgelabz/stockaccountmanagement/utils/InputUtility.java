package com.bridgelabz.stockaccountmanagement.utils;

import java.util.Scanner;

public class InputUtility {
	private static final Scanner scanner = new Scanner(System.in);

	// Utility classes should not have public constructors
	private InputUtility() {

	}

	/**
	 * static method to take byte from user.
	 * 
	 * @return byte value which is given by user
	 */
	public static byte readByte() {
		return scanner.nextByte();
	}

	/**
	 * static method to take integer from user
	 * 
	 * @return integer value which is given by user
	 */

	public static int readInt() {
		return scanner.nextInt();
	}

	/**
	 * static method to take short from user
	 * 
	 * @return short value which is given by user
	 */

	public static short readShort() {
		return scanner.nextShort();
	}

	/**
	 * static method to take long from user
	 * 
	 * @return long value which is given by user
	 */

	public static long readLong() {
		return scanner.nextLong();
	}

	/**
	 * static method to take double from user
	 * 
	 * @return double value which is given by user
	 */

	public static double readDouble() {
		return scanner.nextDouble();
	}

	/**
	 * static method to take boolean from user
	 * 
	 * @return boolean value which is given by user
	 */

	public static boolean readBoolean() {
		return scanner.nextBoolean();
	}

	/**
	 * static method to take float from user
	 * 
	 * @return float value which is given by user
	 */

	public static float readFloat() {
		return scanner.nextFloat();
	}

	/**
	 * static method to take String from user
	 * 
	 * @return String value which is given by user
	 */
	// naming of method
	public static String readString() {
		return scanner.next();
	}

	/**
	 * static method to take String from user
	 * 
	 * @return String value which is given by user and move to next line
	 */

	public static String readStringLine() {
		return scanner.nextLine();
	}

	/**
	 * static method to take char from user
	 * 
	 * @return string value and char value at 0 index which is given by user
	 */

	public static char readChar() {
		return scanner.next().charAt(0);
	}



}
