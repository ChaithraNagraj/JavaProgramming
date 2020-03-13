package com.bridgelabz.clinicmanagement.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bridgelabz.clinicmanagement.model.Appointment;
import com.bridgelabz.clinicmanagement.model.AppointmentModel;
import com.bridgelabz.clinicmanagement.model.Availability;
import com.bridgelabz.clinicmanagement.model.Doctor;
import com.bridgelabz.clinicmanagement.model.DoctorModel;
import com.bridgelabz.clinicmanagement.model.Patient;
import com.bridgelabz.clinicmanagement.model.PatientModel;
import com.bridgelabz.clinicmanagement.repositry.JsonUtil;

public class ImplcliniqueUtil extends ICliniqueUtil{
	final static Logger logger = Logger.getLogger(DoctorAppointmentUtil.class);
	// instantiation
		private static int doctorid = 0;
		private static int patientid = 1000;
		private static int appointmentid = 10000;

		private static Scanner scanner = new Scanner(System.in);

		// file paths
		private String pathDoctorJson = "F:\\jsonfiles\\ClinicManagement\\doctor.json";
		private String pathPatientJson = "F:\\jsonfiles\\ClinicManagement\\patient.json";
		private String pathAppointmentJson = "F:\\jsonfiles\\ClinicManagement\\appointment.json";

		// models
		private DoctorModel modelDoctor = new DoctorModel();
		private PatientModel modelPatient = new PatientModel();
		private AppointmentModel modelAppointment = new AppointmentModel();

		// initialization of lists of doctors patients and appointments
		private static List<Doctor> doctors = new ArrayList<>();
		private static List<Patient> patients = new ArrayList<>();
		private static List<Appointment> appointments = new ArrayList<>();

		/**
		 * Purpose: reading all the json files
		 */
		public void readJson() {

			// checking whether path file is exits or not if exist then add data into lists
			File fileDoctor = new File(pathDoctorJson);
			File filePatient = new File(pathPatientJson);
			File fileAppointment = new File(pathAppointmentJson);
			// checking whether doctor file is empty or not
			if (fileDoctor.exists() && fileDoctor.length() > 0) {
				try {
					modelDoctor = (DoctorModel) JsonUtil.readMapper(pathDoctorJson, modelDoctor);
				} catch (IOException e) {
					e.printStackTrace();
				}
				doctors.addAll(modelDoctor.getDoctors());
				doctorid = doctors.get(doctors.size() - 1).getDrid();
			}

			// checking whether patient file is empty or not
			if (filePatient.exists() && filePatient.length() > 0) {
				try {
					modelPatient = (PatientModel) JsonUtil.readMapper(pathPatientJson, modelPatient);
				} catch (IOException e) {
					e.printStackTrace();
				}
				patients.addAll(modelPatient.getPatients());
				patientid = patients.get(patients.size() - 1).getPtid();
			}

			// checking whether appointment file is empty or not
			if (fileAppointment.exists() && fileAppointment.length() > 0) {
				try {
					modelAppointment = (AppointmentModel) JsonUtil.readMapper(pathAppointmentJson, modelAppointment);
				} catch (IOException e) {
					e.printStackTrace();
				}
				appointments.addAll(modelAppointment.getAppointments());
				appointmentid = appointments.get(appointments.size() - 1).getAptid();
			}

		}

		/**
		 * Purpose:method for reading the details of doctor from the user
		 */
		public Doctor getDoctor() {
			logger.info("->adding doctor<-");
			Doctor doctor = new Doctor();
			doctorid++;
			doctor.setDrid(doctorid);
			logger.info("Enter doctor name: ");
			doctor.setDrname("Dr. " + scanner.next());
			logger.info("Enter doctor specialization: ");
			doctor.setDrspecialization(scanner.next());
			logger.info("->availability<-");
			Availability availability = new Availability();
			logger.info("Time format is of 24 hr");
			logger.info("Date format is dd/MM/yyyy");
			logger.info("");
			logger.info("Enter doctor time in: ");
			availability.setTimein(scanner.nextInt());
			logger.info("Enter doctor time out: ");
			availability.setTimeout(scanner.nextInt());
			logger.info("Enter doctor date");
			availability.setDate(scanner.next());
			doctor.setDravailability(availability);
			doctor.setNoofpatient(0);
			return doctor;
		}

		/**
		 * Purpose: method for adding doctor
		 * 
		 * @param doctor
		 */
		public void addDoctor(Doctor doctor) {

			doctors.add(doctor);
			boolean close = false;
			while (!close) {

				logger.info("Doctor added...");
				logger.info("Enter 1. to add another doctor 2. close");
				if (scanner.nextInt() == 1) {
					close = false;
					doctors.add(getDoctor());
				} else {
					close = true;
					logger.info("Please remember to save to persist records");
					logger.info("closing...");
				}

			}

		}

		/**
		 * Purpose: method for getting details of patient from the user
		 */
		public Patient getPatient() {
			logger.info("->adding patient<-");
			Patient patient = new Patient();
			patientid++;
			patient.setPtid(patientid);
			logger.info("Enter patient name: ");
			patient.setPtname(scanner.next());
			logger.info("Enter patient age: ");
			patient.setPtage(scanner.nextInt());
			logger.info("Enter patient mobile: ");
			patient.setPtmobile(scanner.next());

			return patient;
		}

		/**
		 * Purpose: method for adding patient
		 */
		public void addPatient(Patient patient) {
			boolean close = false;
			patients.add(patient);
			while (!close) {

				logger.info("Patient added...");
				logger.info("Enter 1. to add another patient 2. close");
				if (scanner.nextInt() == 1) {
					close = false;
					patients.add(getPatient());
				} else {
					close = true;
					logger.info("Please remember to save to persist records");
					logger.info("closing...");
				}

			}
		}

		/**
		 * Purpose: method for searching doctor by id
		 */
		public void searchDoctorById() {
			if (doctors.size() > 0) {
				logger.info("Instruction->Doctor id starts from 1");
				logger.info("Enter doctor id to search: ");

				var num = scanner.nextInt();
				doctors.forEach(i -> {
					if (num == i.getDrid()) {
						logger.info(i);
					}

				});
			}

		}

		/**
		 * Purpose: method for searching doctor by name
		 */
		public void searchDoctorByName() {
			if (doctors.size() > 0) {
				logger.info("Enter doctor name to search: ");

				var str = scanner.next();
				doctors.forEach(i -> {
					if (str.equals(i.getDrname()))
					  logger.info(i);

				});
			}

		}

		/**
		 * Purpose: method for getting doctor name from the user
		 */
		public String getDoctorName() {
			logger.info("Enter doctor specialization to search: ");
			var str = scanner.next();
			return str;
		}

		/**
		 * Purpose: method for searching doctor by specialization
		 * 
		 * @return returns true if doctor with speciality is found else return false
		 */
		public boolean searchDoctorBySpecialization(String str) {
			if (doctors.size() > 0) {
				int j = 1;
				for (int i = 0; i < doctors.size(); i++) {
					if (str.equals(doctors.get(i).getDrspecialization())) {
						logger.info(str + " Dr->");
						showDoctorList(i, j++);
						return true;
					}
				}

			}
			return false;

		}

		/**
		 * Purpose: method for searching doctor by Availability
		 * 
		 * @param str  date
		 * @param time time
		 * 
		 * @return returns true if doctor available for date and time else return false
		 */
		public boolean searchDoctorByAvailability(String str, int time) {
			if (doctors.size() > 0) {

				boolean isDoctorAvailable = false;
				for (int i = 0; i < doctors.size(); i++) {
					if (str.equals(doctors.get(i).getDravailability().getDate())
							&& (time >= doctors.get(i).getDravailability().getTimein()
									&& time <= doctors.get(i).getDravailability().getTimeout())) {
						logger.info(str + " Dr->");
						showDoctorList(i, ++i);
						isDoctorAvailable = true;

					}
				}
				if (isDoctorAvailable)
					return true;
			}
			return false;

		}

		/**
		 * Purpose: method for searching patient by id
		 * 
		 * @param num patient id
		 */
		public boolean searchPatientById(int num) {
			if (patients.size() > 0) {

				for (int i = 0; i < patients.size(); i++) {
					if (num == patients.get(i).getPtid()) {
						showPatientList(i, true);
						return true;
					}

				}
			}
			return false;

		}

		/**
		 * Purpose: method for showing patient list
		 * 
		 * @param index           index for which record is going to be print
		 * @param hasSingleRecord if single record is true the shows the details line
		 *                        else not shown
		 */
		public void showPatientList(int index, boolean hasSigleRecord) {
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

		/**
		 * Purpose: method for searching patient by name
		 */
		public void searchPatientByName() {
			if (patients.size() > 0) {
				logger.info("Enter patient name to search: ");
				var str = scanner.next();
				patients.forEach(i -> {
					if (str.equals(i.getPtname()))
					logger.info(i);
				});
			}

		}

		/**
		 * Purpose: method for searching patient by mobile
		 */
		public void searchPatientByMobile() {
			if (patients.size() > 0) {
				logger.info("Enter patient mobile to search: ");
				var str = scanner.next();
				patients.forEach(i -> {
					if (str.equals(i.getPtmobile()))
						logger.info(i);
				});
			}

		}

		/**
		 * Purpose: method for adding appointment
		 */
		public void addAppointment() {
			if (doctors.size() < 1) {
				logger.info("Please add doctor first!");
			} else {
				if (patients.size() < 1) {
					logger.info("Please add patient first!");
				} else {
					validatedCriteria();
				}
			}
		}

		/**
		 * Purpose: method for validating criteria for booking appointment
		 */
		public void validatedCriteria() {
		 logger.info("Enter doctor specialization to search: ");
			var str = scanner.next();
			boolean isDoctorFind = searchDoctorBySpecialization(str);
			if (!isDoctorFind) {
			logger.info("No doctor found");
			} else {
				logger.info("Enter doctor no. ");
				int index = scanner.nextInt() - 1;
				logger.info(doctors.get(index).getDrname());
				logger.info("Dr. available on: " + doctors.get(index).getDravailability().getDate());
				logger.info("proceed (yes/no)");
				String yesOrNo = scanner.next().toLowerCase();
				if (yesOrNo.equals("no"))
					logger.info("Thank you for your time");
				else if (yesOrNo.equals("yes")) {
					logger.info("Enter time");
					int time = scanner.nextInt();
					boolean timeIsAvailable = searchDoctorByAvailability(doctors.get(index).getDravailability().getDate(),
							time);
					if (!timeIsAvailable)
						logger.info("No time available");
					else {
						logger.info("Time is available");
						if (doctors.get(index).getNoofpatient() > 5)
							logger.info("Doctor exceed the limit of patient");
						else {
							logger.info("Enter patient id: ");
							int patientId = scanner.nextInt();
							if (!searchPatientById(patientId))
								logger.info("No patient found with this id");
							else {
								logger.info("To book appointment press (yes/no)");
								if (scanner.next().toLowerCase().equals("yes")) {
									Appointment appointment = getAppointment(index, patientId);
									savingAppointment(appointment);
								}
							}
						}
					}
				}
			}

		}

		public void savingAppointment(Appointment appointment) {
			appointments.add(appointment);
			modelAppointment.setAppointments(appointments);
			try {
				JsonUtil.writeMapper(pathDoctorJson, modelDoctor);
				JsonUtil.writeMapper(pathAppointmentJson, modelAppointment);
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.info("Appointment Booked...");

		}

		public Appointment getAppointment(int index, int patientId) {
			Appointment appointment = new Appointment();
			appointmentid++;
			appointment.setAptid(appointmentid);
			appointment.setDrid(doctors.get(index).getDrid());
			appointment.setDrname(doctors.get(index).getDrname());
			appointment.setDravailability(doctors.get(index).getDravailability().getDate());
			appointment.setPtid(patientId);
			int i = getPatientIndexById(patientId);
			appointment.setPtassignname(patients.get(i).getPtname());
			appointment.setPtassignmobile(patients.get(i).getPtmobile());
			int nopt = doctors.get(index).getNoofpatient();
			nopt = nopt + 1;
			doctors.get(index).setNoofpatient(nopt);
			modelDoctor.setDoctors(doctors);

			return appointment;
		}

		public int getPatientIndexById(int patientId) {
			for (int i = 0; i < patients.size(); i++) {
				if (patientId == patients.get(i).getPtid()) {
					return i;
				}
			}
			return -1;
		}

		/**
		 * Purpose: saving into json
		 */
		public void save() {
			if (doctors.size() > 0) {
				modelDoctor.setDoctors(doctors);
				try {
					JsonUtil.writeMapper(pathDoctorJson, modelDoctor);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			// saving patient
			if (patients.size() > 0) {
				modelPatient.setPatients(patients);
				try {
					JsonUtil.writeMapper(pathPatientJson, modelPatient);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			// saving appointment
			if (appointments.size() > 0) {
				modelAppointment.setAppointments(appointments);
				try {
					JsonUtil.writeMapper(pathAppointmentJson, modelAppointment);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			logger.info("Saving...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Purpose: showing all records
		 */
		@Override
		public void showAllRecords() {
			if (doctors.size() > 0) {
				logger.info("NoOfPatient\tDoctor record");
				for (int i = 0; i < doctors.size(); i++) {
					logger.info(doctors.get(i).getNoofpatient() + "\t\t");
					logger.info(doctors.get(i).getDrid() + "\t");
					showDoctorList(i, false);
				}
			}
			if (patients.size() > 0) {
				logger.info("Patient records");
				for (int i = 0; i < patients.size(); i++) {
					showPatientList(i, false);
				}
			}

			if (appointments.size() > 0) {
				logger.info("Appointment records");

				appointments.forEach(i -> {
					logger.info(i.getAptid() + " " + i.getDrid() + " " + i.getDrname() + " " + i.getDravailability()
							+ " " + i.getPtid() + " " + i.getPtassignname() + " " + i.getPtassignmobile());
				});
			}
		}

		/**
		 * Purpose: method for showing list for particular index
		 */
		public void showDoctorList(int index, boolean hasSigleRecord) {
			if (hasSigleRecord) {
				logger.info("Dr details");
				logger.info(doctors.get(index).getDrname() + "\t");
				logger.info(doctors.get(index).getDrspecialization() + "\t");
				logger.info(doctors.get(index).getDravailability().getDate() + "\t");
				logger.info(doctors.get(index).getDravailability().getTimein() + "\t");
				logger.info(doctors.get(index).getDravailability().getTimeout() + "\t");
			} else {
				logger.info(doctors.get(index).getDrname() + "\t");
				logger.info(doctors.get(index).getDrspecialization() + "\t");
				logger.info(doctors.get(index).getDravailability().getDate() + "\t");
			    logger.info(doctors.get(index).getDravailability().getTimein() + "\t");
				logger.info(doctors.get(index).getDravailability().getTimeout() + "\t");
			}

		}

		/**
		 * Purpose: method for showing list for particular index
		 */
		public void showPopularDoctor() {
			sortDoctorList();
			if (doctors.get(0).getNoofpatient() > 0) {
				logger.info("Hospital specialization: " + doctors.get(0).getDrspecialization());
				logger.info("Dr name is: ");
				showDoctorList(0, false);

			} else
				logger.info("No appointments assign to doctor try again later");
		}

		/**
		 * Purpose: method for sorting doctor list on the basis of number of
		 * appointments
		 */
		public void sortDoctorList() {
			for (int i = 0; i < doctors.size() - 1; i++) {
				for (int j = 0; j < doctors.size() - i - 1; j++) {
					if (doctors.get(j).getNoofpatient() < doctors.get(j + 1).getNoofpatient()) {
						Object temp = doctors.get(j);
						doctors.set(j, doctors.get(j + 1));
						doctors.set(j + 1, (Doctor) temp);
					}
				}
			}
		}

		/**
		 * Purpose: method for showing the list with associated numbers
		 * 
		 * @param index input from program
		 * @param num   input from program
		 */
		public void showDoctorList(int index, int num) {

			logger.info(doctors.get(index).getDrid() + ". " + doctors.get(index).getDrname() + "\t");
			logger.info(doctors.get(index).getDrspecialization() + "\t");
			logger.info(doctors.get(index).getDravailability().getDate() + "\t");
			logger.info(doctors.get(index).getDravailability().getTimein() + "\t");
			logger.info(doctors.get(index).getDravailability().getTimeout() + "\t");

		}
}
