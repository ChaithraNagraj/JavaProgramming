package com.bridgelabs.fs.datastructureprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

public class CashCounter {
	final static Logger logger=Logger.getLogger(CashCounter.class);
	public static void main(String args[])
	{ 
		PropertyConfigurator.configure("src//log4j.properties");
		//Utility u=new Utility();
		//Utility.CashCounterLogic q=new Utility.CashCounterLogic();
		int ch = 0;
		do
		{ 
			logger.info(" ");
		   	logger.info("------------Banking Cash Counter-----------");
		   	logger.info("1.Deposit");
		   	logger.info("2.Withdraw");
		   	logger.info("3.Number of people in the Queue ");
		   logger.info("4.Exit");
		   	logger.info(" ");
		   	logger.info("Enter your choice: ");
		   	int choice=InputUtility.intVal();
		   	switch (choice) 
		   	{
		   	case 1:
			   		logger.info("Enter the amount you want to Deposit");
			   		Utility.insert(InputUtility.intVal()); 
			   		Utility.display();
			   		break;
		   	case 2:
			   		logger.info("Enter the amount you want to Withdraw ");
			   		InputUtility.intVal();
			   		Utility.remove();
			   	    logger.info(" Your Available Balance is: "); 
			   		Utility.display();
			   		break;
			case 3:
					int j=Utility.getSize();
					logger.info("The Number of People in Queue is: "+j);			
		   	case 4:
			   		System.exit(0);
		   	default: 
			   		logger.info("You entered wrong choice");
			   		break;
		   	}
	   	}
		while(ch<5);
	}		
}

