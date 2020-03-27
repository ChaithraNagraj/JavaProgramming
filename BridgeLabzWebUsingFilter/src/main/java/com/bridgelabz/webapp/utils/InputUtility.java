package com.bridgelabz.webapp.utils;

import java.util.Scanner;

public class InputUtility {

	private static final Scanner sc = new Scanner(System.in);

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
	
}
