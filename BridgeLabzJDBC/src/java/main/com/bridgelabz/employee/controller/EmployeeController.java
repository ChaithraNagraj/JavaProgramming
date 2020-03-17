package com.bridgelabz.employee.controller;

import com.bridgelabz.employee.services.EmployeeServiceImpl;
import com.bridgelabz.employee.utills.InputUtility;

public class EmployeeController {
	public static void main(String[] args) {
		//LogUtility.setLog("EmployeeController");
		//Logger logger = LogUtility.getLog();
		//System.setProperty("fname", LogUtility.FILEPATH + "EmployeeController.log");
		//String log4jConfigFile = LogUtility.CONFIGPATH;
		//PropertyConfigurator.configure(log4jConfigFile);
		//logger.info("Logger Name : " + logger.getName());

		EmployeeServiceImpl service = new EmployeeServiceImpl();
		int choice = 0;
		String option;
		do {
			System.out.println("enter 1: To INSERT data into employee table");
			System.out.println("enter 2: To SELECT data from employee table");
			System.out.println("enter 3: To UPDATE data into employee table");
			System.out.println("enter 4: To DELETE data from employee table");
			System.out.println("enter 5: To EXIT");
			choice=InputUtility.intVal();
			
			switch (choice) {
			case 1:
				service.InsertEmployeeDetails();
				break;
			case 2:
				service.SelectEmployeeDetails();
				break;
			case 3:
				service.UpdateEmployeeDetails();
				break;
			case 4:
				service.deleteEmployee();
				break;
			case 5:
				System.out.println("Thank You");
				return;
			default:
				System.out.println("Enter valid choice");
			}
				System.out.println();
				System.out.println("Would You like To Continue in Menu (yes/no) ? :");
				option = InputUtility.stringVal();
			} while (option.equalsIgnoreCase("yes"));
			System.out.println("Exited From Employee List");
	}

}
