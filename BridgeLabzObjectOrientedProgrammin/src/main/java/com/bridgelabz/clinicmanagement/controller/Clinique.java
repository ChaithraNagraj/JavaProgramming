package com.bridgelabz.clinicmanagement.controller;

import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.clinicmanagement.model.Doctor;
import com.bridgelabz.clinicmanagement.model.Patient;
import com.bridgelabz.clinicmanagement.services.ImplcliniqueUtil;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.JsonParseException;

public class Clinique {
	final static Logger logger = Logger.getLogger(Clinique.class);
	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		PropertyConfigurator.configure("logger//log4j.properties");
		/**
		 * Operation for doctor appointments
		 * 
		 * add doctor
		 * 
		 * add patient
		 * 
		 * search doctor by id
		 * 
		 * search doctor by name
		 * 
		 * search doctor by specialization
		 * 
		 * search doctor by availability
		 * 
		 * search patient by id
		 * 
		 * search patient by name
		 * 
		 * search patient by mobile
		 * 
		 */

		ImplcliniqueUtil service = new ImplcliniqueUtil();

		// reading json

		service.readJson();

		// creating menu list

		boolean exit = false;

		Scanner scanner = new Scanner(System.in);

		while (!exit) {
			logger.info("\nSelect option from menu\n");

			logger.info(
					"1. add doctor\n2. add patient\n3. search doctor by id\n4. search doctor by name\n5. search doctor by specialization\n6. search doctor by availability\n7. search patient by id\n8. search patient by name\n9. search patient by number\n10. add appointment\n11. save\n12. exit\n13. show records\n14. see popular doctor");
			switch (scanner.nextInt()) {
			case 1:
				// add doctor
				logger.info(" ");
				logger.info("-------------------------add doctor-----------------------");
				logger.info("");

				Doctor doctor = service.getDoctor();
				service.addDoctor(doctor);
				
				logger.info(" ");
				logger.info("-------------------------add doctor-----------------------");
				logger.info(" ");
				break;
			case 2:
				// add patient
		        logger.info(" ");
				logger.info("-------------------------add patient-----------------------");
			    logger.info(" ");

				Patient patient = service.getPatient();

				service.addPatient(patient);

				logger.info(" ");
				logger.info("-------------------------add patient-----------------------");
				logger.info(" ");
				break;
			case 3:
				// search doctor by id
				logger.info(" ");
				logger.info("-------------------------search doctor by id-----------------------");
				logger.info("");

				service.searchDoctorById();

				logger.info("");
			    logger.info("-------------------------search doctor by id-----------------------");
				logger.info("");
				break;
			case 4:
				// search doctor by name
				logger.info(" ");
				logger.info("-------------------------search doctor by name-----------------------");
			    logger.info(" ");

				service.searchDoctorByName();

				logger.info("");
				logger.info("-------------------------search doctor by name-----------------------");
			    logger.info(" ");
				break;
			case 5:
				// search doctor by specialization
				logger.info("");
				logger.info("-------------------------search doctor by specialization-----------------------");
				logger.info(" ");

				String drname = service.getDoctorName();
				service.searchDoctorBySpecialization(drname);

				logger.info(" ");
				logger.info("-------------------------search doctor by specialization-----------------------");
				logger.info("");
				break;
			case 6:
				// search doctor by availability
				logger.info(" ");
				logger.info("-------------------------search doctor by availability-----------------------");
				logger.info(" ");

				logger.info("Enter doctor date: ");
				var str = scanner.next();
			    logger.info("Enter time from");
				int time = scanner.nextInt();

				service.searchDoctorByAvailability(str, time);

			logger.info(" ");
			logger.info("-------------------------search doctor by availability-----------------------");
			logger.info("");
				break;
			case 7:
				// search patient by id
				logger.info(" ");
				logger.info("-------------------------search patient by id-----------------------");
				logger.info("");

				logger.info("Instruction->Patient id starts from 1000 range");
				logger.info("Enter patient id to search: ");
				var num = scanner.nextInt();

				service.searchPatientById(num);

				logger.info("");
				logger.info("-------------------------search patient by id-----------------------");
				logger.info("");
				break;
			case 8:
				// search patient by name
				logger.info(" ");
				logger.info("-------------------------search patient by name-----------------------");
				logger.info(" ");

				service.searchPatientByName();

				logger.info(" ");
				logger.info("-------------------------search patient by name-----------------------");
				logger.info("");
				break;
			case 9:
				// search patient by mobile
				logger.info("-------------------------search patient by mobile-----------------------");
				logger.info("");

				service.searchPatientByMobile();

				logger.info("");
				logger.info("-------------------------search patient by mobile-----------------------");
				logger.info("");
				break;
			case 10:
				// add appointment
		         logger.info("");
				logger.info("-------------------------add appointment-----------------------");
				logger.info("");

				service.addAppointment();

				logger.info("");
			logger.info("-------------------------add appointment-----------------------");
				logger.info("");
				break;
			case 11:
				// save all objects into json
				logger.info("-------------------------save-----------------------");
				logger.info("");
				// saving doctor

				service.save();

				logger.info("");
				logger.info("-------------------------save-----------------------");
				logger.info("");
				break;

			case 12:
				// search patient by id
				exit = true;
				logger.info("Thank you for your time...");
				Thread.sleep(2000);
				break;

			case 13:
				// show records
				service.showAllRecords();
				break;
			case 14:
				service.showPopularDoctor();
				break;
			default:
			logger.info("Please select valid option");
			}
		}

		scanner.close();

	}
}
