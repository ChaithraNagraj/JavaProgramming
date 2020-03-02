package com.bridgelabs.fs.functionalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TwodArray {
	final static Logger logger=Logger.getLogger(TwodArray.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		double[][] b=Utility.readDouble2D();//read and prints the matrix of doubles
		Utility.print(b);
		logger.info(" ");
		boolean[][] d=Utility.readboolean2D();
		Utility.print(d);
		logger.info(" ");
	}

}
