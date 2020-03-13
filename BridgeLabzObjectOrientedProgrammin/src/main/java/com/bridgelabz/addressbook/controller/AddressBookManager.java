package com.bridgelabz.addressbook.controller;

import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.addressbook.serviceprovider.ImplAddressBookUtil;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.JsonParseException;

public class AddressBookManager {
	final static Logger logger = Logger.getLogger(AddressBookManager.class);
	public static void main(String[] args)
			throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		
		PropertyConfigurator.configure("logger//log4j.properties");
		/*
		 * Address book manager
		 * 
		 * newAddressBook()
		 * 
		 * open()
		 * 
		 * close()
		 * 
		 * save()
		 * 
		 * saveAs()
		 * 
		 * quit()
		 * 
		 */
		ImplAddressBookUtil util = new ImplAddressBookUtil();
		util.readJson();

		Scanner scanner = new Scanner(System.in);

		// getting file if exist and if it is json the reading it again
		// and getting all the objects and lists of json into program

		boolean isExitAddressBook = false;
		logger.info("Address book manager\n");
		while (!isExitAddressBook) {

			logger.info("Select menu");
			logger.info("1. New Address Book\n2. Open Address Book\n" + "3. Save Address Book\n"
					+ "4. SaveAs Address Book\n" + "5. Quit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				// new address book
				util.createNewAddressBook();

				break;
			case 2:
				// open
				// opening address book
				util.openAddressBook();

				break;
			case 3:
				// save
				util.save();
				break;
			case 4:
				// saveAs
				util.saveAs();
				break;
			case 5:
				// quit
				logger.info("-----------------------Quit Address Book-----------------------");
				isExitAddressBook = true;
				logger.info("Thank you for your time");

				break;
			default:
				logger.info("Invalid option");
				break;

			}
		}

		scanner.close();
	}

	
}
