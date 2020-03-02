package com.bridgelabs.fs.algorithmprograms;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabs.fs.algorithmprograms.Utility;
public class Primenumbers {
	final static Logger logger = Logger.getLogger(Primenumbers.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		Utility.primenumbersAre();
	}

}
