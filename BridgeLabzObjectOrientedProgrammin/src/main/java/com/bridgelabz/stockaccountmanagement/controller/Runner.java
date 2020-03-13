package com.bridgelabz.stockaccountmanagement.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.blz.fs.userdefinedexception.CustomizedException;
import com.bridgelabz.stockaccountmanagement.repo.StockAccountManagementService;
import com.bridgelabz.stockaccountmanagement.serviceprovider.StockAccountManagementServiceProvoider;
import com.bridgelabz.stockaccountmanagement.utils.InputUtility;
import com.bridgrlabz.stockaccountmanagement.model.UserDTO;

public class Runner {
	final static Logger logger = Logger.getLogger(Runner.class);
	static UserDTO user = new UserDTO();

	public static void main(String[] args) throws CustomizedException {
		PropertyConfigurator.configure("logger//log4j.properties");
		String answer = "";
		StockAccountManagementService service = new StockAccountManagementServiceProvoider();
		do {
			menu();
			int choice = InputUtility.readInt();
			switch (choice) {
			case 1:
				setCreateStock(service);
			case 2:
				setBuy(service);
				break;
			case 3:
				setSell(service);
				break;

			case 4:
				setBuyUpdate(service);
				break;
			case 5:
				setUpdateSell(service);
				break;
			case 6:
				setIsEmpty(service);
				break;
			case 7:
				setDisplay(service);
			default:
				break;
			}
			logger.info("Do you want to continue yes/no: ");
			answer = InputUtility.readString();
		} while (answer.equalsIgnoreCase("yes"));

	}

	private static void menu() {
		logger.info("enter 1 to create and stock account management: ");
		logger.info("enter 2 to add the  bought stock details: ");
		logger.info("enter 3 to add sold stock details: ");
		logger.info("enter 4 to update bought  stock details: ");
		logger.info("enter 5 to update sold stock details: ");
		logger.info("enter 6 to check if particular stock is empty: ");
		logger.info("enter 7 to print the stock report: ");
	}

	private static void setDisplay(StockAccountManagementService service) {
		logger.info("enter the file name:  ");
		user.setFileName(InputUtility.readString());
		service.printStockDetails(user);
	}

	private static void setIsEmpty(StockAccountManagementService service) {
		logger.info("enter the file name: ");
		user.setFileName(InputUtility.readString());
		logger.info("enter the stock name: ");
		user.setShareName(InputUtility.readString());
		service.isStockEmpty(user);
	}

	private static void setUpdateSell(StockAccountManagementService service) throws CustomizedException {
		logger.info("enter the file name: ");
		user.setFileName(InputUtility.readString());
		logger.info("enter the stock name: ");
		user.setShareName(InputUtility.readString());
		logger.info("enter the number of shares sold: ");
		user.setNumberOfSharesSold(InputUtility.readLong());
		logger.info("enter the price of shares sold:  ");
		user.setSoldPrice(InputUtility.readDouble());
		service.updateSoldStock(user);
	}

	private static void setBuyUpdate(StockAccountManagementService service) throws CustomizedException {
		logger.info("enter the file name: ");
		user.setFileName(InputUtility.readString());
		logger.info("enter the stock name: ");
		user.setShareName(InputUtility.readString());
		logger.info("enter the number of shares bought: ");
		user.setNumberOfSharesBought(InputUtility.readLong());
		logger.info("enter the price of shares bought:  ");
		user.setBoughtPrice(InputUtility.readDouble());
		service.updateboughtstock(user);
	}

	private static void setSell(StockAccountManagementService service) throws CustomizedException {
		logger.info("enter the file name: ");
		user.setFileName(InputUtility.readString());
		logger.info("enter the stock name:  ");
		user.setShareName(InputUtility.readString());
		logger.info("enter the number of shares sold: ");
		user.setNumberOfSharesSold(InputUtility.readLong());
		logger.info("enter the sold  price: ");
		user.setSoldPrice(InputUtility.readDouble());
		service.soldStock(user);
	}

	private static void setBuy(StockAccountManagementService service) throws CustomizedException {
		logger.info("enter the file name: ");
		user.setFileName(InputUtility.readString());
		logger.info("enter the share name: ");
		user.setShareName(InputUtility.readString());
		logger.info("enter the stock symbol: ");
		user.setStockSymbol(InputUtility.readString());
		logger.info("enter the number of shares bought: ");
		user.setNumberOfSharesBought(InputUtility.readLong());
		logger.info("enter the bought  price: ");
		user.setBoughtPrice(InputUtility.readDouble());
		service.boughtStock(user);
	}

	private static void setCreateStock(StockAccountManagementService service) {
	logger.info("enter the stock account management name: ");
		user.setFileName(InputUtility.readString());
		service.createStockManagement(user);
	}

}
