package com.bridgelabs.fs.algorithmprograms;

import java.util.Date;

import com.bridglabz.utility.InputUtility;

public class Regex {
	public static void main(String args[])
	{
		Utility u=new Utility();

		UserDetails user=new UserDetails();
		System.out.println();
	
		//asking user to enter his data
		System.out.println("Enter FirstName:");
		user.setfName(InputUtility.stringVal());
		System.out.println();
	
		System.out.println("Enter LastName:");
		user.setlName(InputUtility.stringVal());
		System.out.println();
	
		System.out.println("Enter Mobile Number:");
		user.setmobileNo(InputUtility.stringVal());
		System.out.println();	
		
		//Setting current date
		user.setdate(u.getFormatedDate(new Date()));
		//System.out.println(u.convertString(user,u.getFileText("newfile.txt")));	
	}
}
