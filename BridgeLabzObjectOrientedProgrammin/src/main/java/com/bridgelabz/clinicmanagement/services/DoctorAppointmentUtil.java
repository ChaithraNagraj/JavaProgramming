package com.bridgelabz.clinicmanagement.services;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bridgelabz.clinicmanagement.model.Doctor;
import com.bridgelabz.clinicmanagement.model.Patient;

public class DoctorAppointmentUtil {
	final static Logger logger = Logger.getLogger(DoctorAppointmentUtil.class);
	/**
	 * Purpose: show the records of doctors list
	 * 
	 * @param doctors        list of doctor input from user
	 * @param index          input from user
	 * @param hasSigleRecord input from user
	 */
	public static void showDoctorList(ArrayList<Doctor> doctors, int index, boolean hasSigleRecord) {

		

	}

	/**
	 * Purpose: Printing doctor list with numbers on it
	 * 
	 * @param doctors input from user
	 * @param index   input from user
	 * @param num     input from user
	 */
	public static void showDoctorList(ArrayList<Doctor> doctors, int index, int num) {

		logger.info(doctors.get(index).getDrid() + ". " + doctors.get(index).getDrname() + "\t");
		logger.info(doctors.get(index).getDrspecialization() + "\t");
		logger.info(doctors.get(index).getDravailability().getDate() + "\t");
		logger.info(doctors.get(index).getDravailability().getTimein() + "\t");
		logger.info(doctors.get(index).getDravailability().getTimeout() + "\t");

	}

	/**
	 * Purpose: method for printing patient list
	 * 
	 * @param patients       input from user
	 * @param index          input from user
	 * @param hasSigleRecord input from user
	 */
	public static void showPatientList(ArrayList<Patient> patients, int index, boolean hasSigleRecord) {
		if (hasSigleRecord) {
			logger.info("Patient Details\t\n");
	        logger.info(patients.get(index).getPtid() + "\t");
			logger.info(patients.get(index).getPtname() + "\t");
			logger.info(patients.get(index).getPtage() + "\t");
			logger.info(patients.get(index).getPtmobile() + "\t");
		} else {
		    logger.info(patients.get(index).getPtid() + "\t");
		    logger.info(patients.get(index).getPtname() + "\t");
			logger.info(patients.get(index).getPtage() + "\t");
			logger.info(patients.get(index).getPtmobile() + "\t");
		}
	}
}
