package com.bridgelabs.fs.logicalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;
public class Gambler {
	final static Logger logger=Logger.getLogger(Gambler.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("srrc//log4j.properties");
	logger.info("enter the stake, goal, trials");
	int stake=InputUtility.intVal();
    int goal=InputUtility.intVal();
    int trials=InputUtility.intVal();
    Utility.Gamblerwin(stake, goal,trials);
   
}
	}
