package com.bridgelabz.addressbook.serviceprovider;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bridgelabz.addressbook.model.Address;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.repository.JsonUtil;

public class ImplAddressBookUtil extends IAddressBookUtil {
	final static Logger logger = Logger.getLogger(ImplAddressBookUtil.class);
	
	Scanner scanner = new Scanner(System.in);
	int counter = 0;
	String path = "F:\\jsonfiles\\AddressBokk\\address.json";
	String statename = "";
	static AddressBookModel model = new AddressBookModel();
	static ArrayList<Person> persons = new ArrayList<Person>();

	String search;
	int indexOfPerson;

	/**
	 * Purpose: Printing person detail
	 * 
	 * @param persons   input from user
	 * @param statename input from user
	 */
	public static void PrintPersonDetails(ArrayList<Person> persons, String statename) {
		String str = "";
		str += "Person detail\n";
//		for (int i = 0; i < persons.size(); i++) {
//			if (!statename.isEmpty() && statename.equals(persons.get(i).getAddressObj().getState())) {
//				str += persons.get(i).getFirstname() + " ";
//				str += persons.get(i).getLastname() + " ";
//				str += persons.get(i).getAddressObj().getAddressLocal() + " ";
//				str += persons.get(i).getAddressObj().getCity() + " ";
//				str += persons.get(i).getAddressObj().getState() + " ";
//				str += persons.get(i).getAddressObj().getZip() + " ";
//				str += persons.get(i).getMobile() + " \n";
//			}
//
//		}
		logger.info(str);
		persons.forEach(i -> {
			if (!statename.isEmpty() && statename.equals(i.getAddressObj().getState())) {
				logger.info(i.getFirstname() + " " + i.getLastname() + " " + i.getAddressObj().getAddressLocal()
						+ " " + i.getAddressObj().getCity() + " " + i.getAddressObj().getState() + " "
						+ i.getAddressObj().getZip() + " " + i.getMobile());
			}

		});

		// persons.forEach(System.out::println);
		// return str;
	}

	/**
	 * Purpose: method for reading json in the starting point
	 */
	public void readJson() {
		// checking whether it is empty or not
		File file = new File(path);
		if (file.exists() && file.length() != 0) {
			try {
				model = (AddressBookModel) JsonUtil.readMapper(path, model);
			} catch (IOException e) {
				e.printStackTrace();
			}
			persons.addAll(model.getPersons());
			counter = persons.size();

		}

	}

	/**s
	 * Purpose: creating new address book
	 */
	public void createNewAddressBook() {
		logger.info("-----------------------New Address Book-----------------------");
		logger.info("Enter state name: ");

		statename = scanner.next();

		boolean isFoundState = false;
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getAddressObj().getState().equals(statename)) {
				isFoundState = true;
				break;
			}
		}
		if (!isFoundState) {

			logger.info("->State is added<-");
			boolean close = false;

			while (!close) {
				logger.info(
						"Select option: \n1.add\n2.edit\n3.delete\n4.sort by last name\n5.sort by zip\n6.print\n7.close");
				int ch = scanner.nextInt();
				switch (ch) {
				case 1:
					// add person
					addPerson();

					break;
				case 2:
					// edit person
					editPerson();
					break;
				case 3:
					// delete person
					deletePerson();
					break;
				case 4:
					// sort by last name

					sortByLastName();

					break;
				case 5:
					// sort by zip

					sortByZip();

					break;
				case 6:
					// print

					if (counter > 0) {
						logger.info("Printing all records...");

						ImplAddressBookUtil.PrintPersonDetails(persons, statename);

					} else
						logger.info("There is no record to print...");

					break;
				case 7:
					// close
					close = true;
				logger.info("Closing...");
					break;
				default:
					logger.info("Invalid option");
				}
			}
		} else
			logger.info("State exist please try again");

		logger.info("-----------------------New Address Book-----------------------");

	}

	/**
	 * Purpose: method for opening address book
	 */
	public void openAddressBook() {
		logger.info("-----------------------Open Address Book-----------------------");
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < persons.size(); i++) {
			map.put(persons.get(i).getAddressObj().getState(), persons.get(i).getAddressObj().getState());
		}
	logger.info("states available " + map.keySet());
		logger.info("Enter state");
		statename = scanner.next();
		boolean isFoundState = false;
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getAddressObj().getState().equals(statename)) {
				isFoundState = true;
				break;
			}
		}
		if (isFoundState) {
			logger.info("->State is found<-");
			boolean close2 = false;

			while (!close2) {
				logger.info(
						"Select option: \n1.add\n2.edit\n3.delete\n4.sort by last name\n5.sort by zip\n6.print\n7.quit");
				switch (scanner.nextInt()) {
				case 1:
					// add person
					addPerson();
					break;
				case 2:
					// edit person
					editPerson();
					break;
				case 3:
					// delete person
					deletePerson();
					break;
				case 4:
					// sort by last name
					sortByLastName();

					break;
				case 5:
					// sort by zip

					sortByZip();

					break;
				case 6:
					// print
					if (counter > 0) {
						logger.info("Printing all records...");

						ImplAddressBookUtil.PrintPersonDetails(persons, statename);

					} else
						logger.info("There is no record to print...");

					break;
				case 7:
					// close
					close2 = true;
				logger.info("Closing...");
					break;
				default:
					logger.info("Invalid option");
				}
			}

		} else
			logger.info("Please create new state of that name\nelse try new state name");

		logger.info("-----------------------Open Address Book-----------------------");

	}

	/**
	 * Purpose: method for save object into json file
	 */
	public void save() {
		logger.info("-----------------------Save Address Book-----------------------");

	logger.info("->Saving address book into json<-");
		model.setPersons(persons);
		try {
			JsonUtil.writeMapper(path, model);
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info(" ");
		logger.info("Writing into file successful....");

		logger.info("-----------------------Save Address Book-----------------------");

	}

	/**
	 * Purpose: method for save as which will save object into json file
	 */
	public void saveAs() throws FileNotFoundException {
		logger.info("-----------------------Save As Address Book-----------------------");

	logger.info("->Save as<-");
		logger.info("This option requires path where you want to store file");
		logger.info("for continue press (y/n)");
		if (scanner.next().charAt(0) == 'y') {
			String pathInput = "F:\\jsonfiles\\AddressBokk\\address.json";
			// checking whether path is valid or not
			logger.info("Enter filename");
			pathInput += scanner.next();
			pathInput += ".json";
			if (new File(pathInput).exists()) {
				throw new FileNotFoundException("You cannot rewrite existing file");
			} else {
				// writing into file
				logger.info("->Saving address book into file<-");
				model.setPersons(persons);
				try {
					JsonUtil.writeMapper(pathInput, model);
				} catch (IOException e) {

					e.printStackTrace();
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info(" ");
				logger.info("Writing into file successful....");
			}
		}

		logger.info("-----------------------Save As Address Book-----------------------");

	}

	/**
	 * Purpose: method for adding person
	 */
	public void addPerson() {
		logger.info("Add person details...");
		Person person = new Person();

	logger.info("Enter mobile");
		Long mobile = scanner.nextLong();
		// validating mobile is not taken by anyone
		boolean isMobileTaken = false;
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getMobile() == mobile) {
				isMobileTaken = true;
				break;
			}
		}
		if (isMobileTaken) {
	  logger.info("This mobile number is already taken");
		} else {
			person.setMobile(mobile);
			logger.info("Enter person first name: ");
			person.setFirstname(scanner.next().toLowerCase());
			logger.info("Enter person last name: ");
			person.setLastname(scanner.next().toLowerCase());
			logger.info("Enter address Details: ");
			Address address = new Address();
			logger.info("Enter address: ");
			address.setAddressLocal(scanner.next());
			logger.info("Enter city: ");
			address.setCity(scanner.next());
			address.setState(statename);
			logger.info("Enter zip: ");
			address.setZip(scanner.nextInt());

			person.setAddressObj(address);

			persons.add(person);

			logger.info(" ");
			logger.info("Person added");
			counter++;

		}

	}

	/**
	 * Purpose: method for edit person from array list
	 */
	public void editPerson() {
		if (counter > 0) {
			logger.info("Enter Persons mobile number you want to edit:");
			Long searchMobile = scanner.nextLong();
			indexOfPerson = 0;
			boolean isFoundPerson = false;
			for (int i = 0; i < persons.size(); i++) {
				if (searchMobile == persons.get(i).getMobile()) {
					isFoundPerson = true;
					indexOfPerson = i;
					break;
				}
			}
			if (isFoundPerson) {

				logger.info("enter new address");
				persons.get(indexOfPerson).getAddressObj().setAddressLocal(scanner.next());
				logger.info("enter new city name");
				persons.get(indexOfPerson).getAddressObj().setCity(scanner.next());
				logger.info("enter new zip");
				persons.get(indexOfPerson).getAddressObj().setZip(scanner.nextInt());

				persons.get(indexOfPerson).setMobile(searchMobile);

				logger.info(" ");
				logger.info("Edit completed");

			} else
				logger.info("No person found with this number");
		} else
			logger.info("There is no record to edit");

	}

	/**
	 * Purpose: method for delete Person from array list
	 */
	public void deletePerson() {
		if (counter > 0) {
		logger.info("Enter Persons mobile number you want to delete:");
			Long Mobilesearch = scanner.nextLong();
			indexOfPerson = 0;
			boolean isFoundPerson = false;
			for (int i = 0; i < persons.size(); i++) {
				if (Mobilesearch == persons.get(i).getMobile()) {
					isFoundPerson = true;
					indexOfPerson = i;
					break;
				}
			}
			if (isFoundPerson) {
				persons.remove(indexOfPerson);
				counter--;
				logger.info(" ");
				logger.info("Delete completed");
			} else
				logger.info("No person found with this number");
		} else
			logger.info("No records to delete");

	}

	/**
	 * Purpose: method for sorting object by the last name
	 */
	public void sortByLastName() {
		if (counter > 1) {
			logger.info("Sorting by Last name is selected");

//			for (int i = 0; i < persons.size() - 1; i++) {
//				for (int j = 0; j < persons.size() - i - 1; j++) {
//
//					if (persons.get(j).getLastname().compareTo(persons.get(j + 1).getLastname()) > 0) {
//						Object temp = persons.get(j);
//						persons.set(j, persons.get(j + 1));
//						persons.set(j + 1, (Person) temp);
//
//					}
//				}
//			}
			Collections.sort(persons, (e1, e2) -> e1.getLastname().compareTo(e2.getLastname()));
			logger.info("Please wait...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.info("Sorting is completed to see the result select print option");
		} else
			logger.info("Less records to sort");

	}

	/**
	 * Purpose: method for sorting object by zip
	 */
	public void sortByZip() {
		if (counter > 1) {
	logger.info("Sorting by zip");

//			for (int i = 0; i < persons.size() - 1; i++) {
//				for (int j = 0; j < persons.size() - i - 1; j++) {
//
//					if (persons.get(j).getAddressObj().getZip() > persons.get(j + 1).getAddressObj().getZip()) {
//						Object temp = persons.get(j);
//						persons.set(j, persons.get(j + 1));
//						persons.set(j + 1, (Person) temp);
//
//					}
//				}
//			}
			Collections.sort(persons, (e1, e2) -> String.valueOf(e1.getAddressObj().getZip())
					.compareTo(String.valueOf(e2.getAddressObj().getZip())));
			logger.info("Please wait...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("Sorting is completed to see the result select print option");
		} else
			logger.info("Less records to sort");

	}
}
