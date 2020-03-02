package com.bridgelabs.fs.datastructureprograms;

import com.bridglabz.utility.InputUtility;

public class CalenderQueue {
public static void main(String[] args) {
	System.out.println("enter the month");
	int month=InputUtility.intVal();
	System.out.println(" enther the year");
	int year=InputUtility.intVal();
	Utility.printQueueCalendar(month, year);
}
}
