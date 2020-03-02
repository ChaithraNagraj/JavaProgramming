package com.bridgelabs.fs.junitprograms;

import org.apache.log4j.Logger;

import com.bridglabz.utility.InputUtility;

public class Temparatureconv {
	final static Logger logger = Logger.getLogger(Temparatureconv.class);
    public static void main(String[] args) {
	logger.info("enter the temp in celsius");
	double c=InputUtility.doubleVal();
	logger.info("converted temeperatureis" + Utility.tempinFahrenheit(c));
	logger.info("enter the temp in fahrenheit");
	double f=InputUtility.doubleVal();
	logger.info("coverted temperature is"+ Utility.tempinCelsius(f));


}
}
