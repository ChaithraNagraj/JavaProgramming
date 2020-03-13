package com.bridgelabz.stockaccountmanagement.serviceprovider;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.blz.fs.userdefinedexception.CustomizedException;
import com.bridgelabz.stockaccountmanagement.controller.Runner;
import com.bridgelabz.stockaccountmanagement.repo.StockAccountManagementService;
import com.bridgelabz.stockaccountmanagement.repo.StockAccountMangementRepo;
import com.bridgelabz.stockaccountmanagement.utils.LinkedList;
import com.bridgelabz.stockaccountmanagement.utils.Queue;
import com.bridgelabz.stockaccountmanagement.utils.Stack;
import com.bridgrlabz.stockaccountmanagement.model.UserDTO;

public  class StockAccountManagementServiceProvoider implements StockAccountManagementService {
	final static Logger logger = Logger.getLogger(Runner.class);
	LinkedList<JSONObject>list=new LinkedList<>();
	Queue<String>queue=new Queue<>();
	Stack<String>stack=new Stack<>();
	/**
	 * method to get current date and time
	 * 
	 * @return String
	 */
	public static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String date = formatter.format(new Date());
		return date;
	}

	/**
	 * method to create stock management
	 */
	public void createStockManagement(UserDTO user) {
		JSONArray stockDetails = new JSONArray();
		StockAccountMangementRepo.writeToFile(stockDetails, user.getFileName());

	}

	/**
	 * method to add bought stock to the stock management
	 * 
	 * @throws CustomizedException
	 */
	@SuppressWarnings("unchecked")
	public void boughtStock(UserDTO user) throws CustomizedException {
		JSONArray stockManagement = StockAccountMangementRepo.readFromFile(user.getFileName());
		JSONObject stockManagementDetails = new JSONObject();
		stockManagementDetails.put("StockName", user.getShareName());
		stockManagementDetails.put("Symbol", user.getStockSymbol());
		stack.push(user.getStockSymbol());
		JSONObject stockDetails = new JSONObject();
		JSONArray buy = new JSONArray();
		JSONObject buyDetails = buyDetails(user);
		buy.add(buyDetails);
		stockDetails.put("Buy", buy);
		stockManagementDetails.put("StockDetails", stockDetails);
		stockManagement.add(stockManagementDetails);
		StockAccountMangementRepo.writeToFile(stockManagement, user.getFileName());

	}

	/**
	 * method to create buyDetails object
	 * 
	 * @param user
	 * @return
	 * @throws CustomizedException
	 */
	@SuppressWarnings("unchecked")
	private JSONObject buyDetails(UserDTO user) throws CustomizedException {
		JSONObject buyDetails = new JSONObject();
		if (user.getBoughtPrice() < 0 || user.getNumberOfSharesBought() < 0) {
			throw new CustomizedException("shares and prices cant be less than zero");
		} else {
			buyDetails.put("Quantity", user.getNumberOfSharesBought());
			buyDetails.put("Price", user.getBoughtPrice());
			buyDetails.put("Date", getDate());
			queue.enqueue(getDate());
		}
		return buyDetails;
	}

	/**
	 * overloaded method to create a buy details object
	 * 
	 * @param quantity
	 * @param price
	 * @return
	 * @throws CustomizedException
	 */
	@SuppressWarnings("unchecked")
	public JSONObject buyDetails(long quantity, double price) throws CustomizedException {
		JSONObject buyDetails = new JSONObject();
		if (price < 0 || quantity < 0.0) {
			throw new CustomizedException("shares and prices cant be less than zero");
		} else {
			buyDetails.put("Quantity", quantity);
			buyDetails.put("Price", price);
			buyDetails.put("Date", getDate());
			queue.enqueue(getDate());
		}

		return buyDetails;

	}

	/**
	 * method to add the sold stock to the stock management
	 * 
	 * @throws CustomizedException
	 */
	@SuppressWarnings("unchecked")
	public void soldStock(UserDTO user) throws CustomizedException {
		long boughtQuantity = 0;
		double boughtPrice = 0.0;
		JSONArray stockManagement = StockAccountMangementRepo.readFromFile(user.getFileName());
		for (int i = 0; i < stockManagement.size(); i++) {
			JSONObject stockManagementDetails = (JSONObject) stockManagement.get(i);
			String stockName = (String) stockManagementDetails.get("StockName");
			if (stockName.equalsIgnoreCase(user.getShareName())) {
				JSONObject stockDetails = (JSONObject) stockManagementDetails.get("StockDetails");
				JSONArray buy = (JSONArray) stockDetails.get("Buy");
				JSONObject buyDetails = null;
				for (int j = 0; j < buy.size(); j++) {
					buyDetails = (JSONObject) buy.get(j);
					boughtQuantity = (long) buyDetails.get("Quantity");
					boughtPrice = (double) buyDetails.get("Price");
				}
				long quantity = boughtQuantity - user.getNumberOfSharesSold();
				JSONObject newbuyDetails = buyDetails(quantity, boughtPrice);
				JSONArray sell = new JSONArray();
				JSONObject sellDetails = sellDetails(user);
				sell.add(sellDetails);
				buy.remove(buyDetails);
				buy.add(newbuyDetails);
				stockDetails.put("Sell", sell);
				stockManagementDetails.put("StockDetails", stockDetails);
				StockAccountMangementRepo.writeToFile(stockManagement, user.getFileName());
				break;
			}

		}

	}

	/**
	 * method to create a sell details object
	 * 
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private JSONObject sellDetails(UserDTO user) {
		JSONObject sellDetails = new JSONObject();
		sellDetails.put("Quantity", user.getNumberOfSharesSold());
		sellDetails.put("Price", user.getSoldPrice());
		sellDetails.put("Date", getDate());
		queue.enqueue(getDate());
		return sellDetails;
	}

	/**
	 * method to update bought stock to the stock management
	 * 
	 * @throws CustomizedException
	 */
	@SuppressWarnings("unchecked")
	public void updateboughtstock(UserDTO user) throws CustomizedException {
		JSONArray stockManagement = StockAccountMangementRepo.readFromFile(user.getFileName());
		for (int i = 0; i < stockManagement.size(); i++) {
			JSONObject stockManagementDetails = (JSONObject) stockManagement.get(i);
			String stockName = (String) stockManagementDetails.get("StockName");
			if (stockName.equalsIgnoreCase(user.getShareName())) {
				JSONObject stockDetails = (JSONObject) stockManagementDetails.get("StockDetails");
				JSONArray buy = (JSONArray) stockDetails.get("Buy");
				JSONObject buyDetails = (JSONObject) buy.get(0);
				long quantity = (long) buyDetails.get("Quantity");
				if (quantity == 0) {
					JSONObject newBuyDetails = buyDetails(user);
					//buy.remove(buyDetails);
					buy.add(newBuyDetails);
					stockDetails.put("Buy", buy);
					stockManagementDetails.put("StockDetails", stockDetails);
					
					StockAccountMangementRepo.writeToFile(stockManagement, user.getFileName());
					break;
				}
			}
		}

	}

	/**
	 * method to update the sold stock to the stock management
	 * 
	 * @throws CustomizedException
	 */
	@SuppressWarnings("unchecked")
	public void updateSoldStock(UserDTO user) throws CustomizedException {
		long boughtQuantity = 0;
		double price = 0.0;
		JSONArray stockManagement = StockAccountMangementRepo.readFromFile(user.getFileName());
		for (int i = 0; i < stockManagement.size(); i++) {
			JSONObject stockManagementDetails = (JSONObject) stockManagement.get(i);
			String stockName = (String) stockManagementDetails.get("StockName");
			if (stockName.equalsIgnoreCase(user.getShareName())) {
				JSONObject stockDetails = (JSONObject) stockManagementDetails.get("StockDetails");
				JSONArray buy = (JSONArray) stockDetails.get("Buy");
				JSONObject buyDetails = null;
				for (int j = 0; j < buy.size(); j++) {
					buyDetails = (JSONObject) buy.get(j);
					boughtQuantity = (long) buyDetails.get("Quantity");
					price = (double) buyDetails.get("Price");
				}
				if (user.getNumberOfSharesSold() > boughtQuantity) {
					throw new CustomizedException("sorry, we dont have that quantity of stock");
				}
				long quantity = boughtQuantity - user.getNumberOfSharesSold();
				JSONObject newbuyDetails = buyDetails(quantity, price);
				JSONArray sell = (JSONArray) stockDetails.get("Sell");
				JSONObject sellDetails = new JSONObject();
				sellDetails.put("Quantity", user.getNumberOfSharesSold());
				sellDetails.put("Price", user.getSoldPrice());
				sellDetails.put("Date", getDate());
				queue.enqueue(getDate());
				sell.add(sellDetails);
				buy.remove(buyDetails);
				buy.add(newbuyDetails);
				stockDetails.put("Sell", sell);
				stockManagementDetails.put("StockDetails", stockDetails);
				StockAccountMangementRepo.writeToFile(stockManagement, user.getFileName());
				break;
			}
		}

	}

	/**
	 * method to check if stock is empty
	 * 
	 * @return boolean true if stock is empty else false if stock is not empty
	 * 
	 */
	public boolean isStockEmpty(UserDTO user) {
		JSONArray stockManagement = StockAccountMangementRepo.readFromFile(user.getFileName());
		for (int i = 0; i < stockManagement.size(); i++) {
			JSONObject stockManagementDetails = (JSONObject) stockManagement.get(i);
			String stockName = (String) stockManagementDetails.get("StockName");
			if (stockName.equalsIgnoreCase(user.getShareName())) {
				long totalBought = 0;
				long totalSold = 0;
				JSONObject stockDetails = (JSONObject) stockManagementDetails.get("StockDetails");
				JSONArray buy = (JSONArray) stockDetails.get("Buy");
				for (int j = 0; j < buy.size(); j++) {
					JSONObject buyDetails = (JSONObject) buy.get(j);
					long quantitybought = (long) buyDetails.get("Quantity");
					totalBought = totalBought + quantitybought;
				}
				JSONArray sell = (JSONArray) stockDetails.get("Sell");
				for (int k = 0; k < sell.size(); k++) {
					JSONObject sellDetails = (JSONObject) sell.get(k);
					long quantitySold = (long) sellDetails.get("Quantity");
					totalSold = totalSold + quantitySold;

				}
				if (totalBought == totalSold) {
					logger.info("out Of Stock");
					return true;
				} else {
					long inStock = totalBought - totalSold;
					logger.info(inStock + " left");
				}
			}
		}
		return false;

	}

	/**
	 * overloaded method to check if the stock is empty
	 * 
	 * @param stocked
	 * @param fileName
	 * @return
	 */
	public boolean isStockEmpty(String stocked, String fileName) {
		JSONArray stockManagement = StockAccountMangementRepo.readFromFile(fileName);
		for (int i = 0; i < stockManagement.size(); i++) {
			JSONObject stockManagementDetails = (JSONObject) stockManagement.get(i);
			String stockName = (String) stockManagementDetails.get("StockName");
			if (stockName.equalsIgnoreCase(stocked)) {
				long totalBought = 0;
				long totalSold = 0;
				JSONObject stockDetails = (JSONObject) stockManagementDetails.get("StockDetails");
				JSONArray buy = (JSONArray) stockDetails.get("Buy");
				for (int j = 0; j < buy.size(); j++) {
					JSONObject buyDetails = (JSONObject) buy.get(j);
					long quantitybought = (long) buyDetails.get("Quantity");
					totalBought = totalBought + quantitybought;
				}
				JSONArray sell = (JSONArray) stockDetails.get("Sell");
				if (sell != null) {
					for (int k = 0; k < sell.size(); k++) {
						JSONObject sellDetails = (JSONObject) sell.get(k);
						long quantitySold = (long) sellDetails.get("Quantity");
						totalSold = totalSold + quantitySold;
					}
				}
				if (totalBought == 0) {
					logger.info("out Of Stock");
					return true;
				} else {
					long inStock = totalBought;
					logger.info(inStock + " left");
				}
			}
		}
		return false;

	}

	/**
	 * method to print the stock details
	 */
	public void printStockDetails(UserDTO user) {
		JSONArray stockManagement = StockAccountMangementRepo.readFromFile(user.getFileName());
		for (int i = 0; i < stockManagement.size(); i++) {
			JSONObject stockManagementDetails = (JSONObject) stockManagement.get(i);
			String stockName = (String) stockManagementDetails.get("StockName");
			logger.info("StockName: " + stockName);
			logger.info("---------------------------");
			logger.info("----------------------------");
			JSONObject stockDetails = (JSONObject) stockManagementDetails.get("StockDetails");
			JSONArray buy = (JSONArray) stockDetails.get("Buy");
			if (buy != null) {
				logger.info("Buy Details: ");
				logger.info("---------------------");
				for (int j = 0; j < buy.size(); j++) {

					JSONObject buyDetails = (JSONObject) buy.get(j);
					String date = (String) buyDetails.get("Date");
					logger.info("Date: " + date);
					long quantity = (long) buyDetails.get("Quantity");
					logger.info("Quantity: " + quantity);
					double price = (double) buyDetails.get("Price");
					logger.info("Price: " + price);
					logger.info("-----------------------------");
				}
			}

			logger.info("TotalInvested: " + investment(stockName, user.getFileName()));
			logger.info("Sell Details: ");
			System.out.println("----------------------------------");
			JSONArray sell = (JSONArray) stockDetails.get("Sell");
			if (sell != null) {

				for (int k = 0; k < sell.size(); k++) {
					JSONObject sellDetails = (JSONObject) sell.get(k);
					String date = (String) sellDetails.get("Date");
					logger.info("Date: " + date);
					long quantity = (long) sellDetails.get("Quantity");
				    logger.info("Quantity: " + quantity);
					double price = (double) sellDetails.get("Price");
				    logger.info("Price: " + price);
					logger.info("-----------------------------");
				}
			}
			logger.info("TotalGained: " + gained(stockName, user.getFileName()));
			logger.info("------------------------");
			isStockEmpty(stockName, user.getFileName());
			logger.info("----------------------");
		     
		}

	}

	/**
	 * method to get invested amount on a particular item
	 * 
	 * @param stocked
	 * @param fileName
	 */
	public double investment(String stocked, String fileName) {
		double totalInvested = 0;
		JSONArray stockManagement = StockAccountMangementRepo.readFromFile(fileName);
		for (int i = 0; i < stockManagement.size(); i++) {
			JSONObject stockManagementDetails = (JSONObject) stockManagement.get(i);
			String stockName = (String) stockManagementDetails.get("StockName");
			if (stockName.equalsIgnoreCase(stocked)) {

				JSONObject stockDetails = (JSONObject) stockManagementDetails.get("StockDetails");
				JSONArray buy = (JSONArray) stockDetails.get("Buy");
				for (int j = 0; j < buy.size(); j++) {
					JSONObject buyDetails = (JSONObject) buy.get(j);
					double invested = (double) buyDetails.get("Price");
					totalInvested = totalInvested + invested;
				}
			}
		}
		return totalInvested;

	}

	/**
	 * method to calculate amount returned on the stock
	 * 
	 * @param stocked
	 * @param fileName
	 */
	public double gained(String stocked, String fileName) {
		double totalGained = 0;
		JSONArray stockManagement = StockAccountMangementRepo.readFromFile(fileName);
		for (int i = 0; i < stockManagement.size(); i++) {
			JSONObject stockManagementDetails = (JSONObject) stockManagement.get(i);
			String stockName = (String) stockManagementDetails.get("StockName");
			if (stockName.equalsIgnoreCase(stocked)) {

				JSONObject stockDetails = (JSONObject) stockManagementDetails.get("StockDetails");
				JSONArray sell = (JSONArray) stockDetails.get("Sell");
				if (sell != null) {
					for (int k = 0; k < sell.size(); k++) {
						JSONObject sellDetails = (JSONObject) sell.get(k);
						double gain = (double) sellDetails.get("Price");
						totalGained = totalGained + gain;

					}
				}

			}
		}
		return totalGained;

	}
	/**
	 * method to add shares to linked list
	 * @param fileName
	 */
	public void addSharesTOLinkedList(UserDTO user)
	{
		JSONArray stockManagement = StockAccountMangementRepo.readFromFile(user.getFileName());
		for (int i = 0; i < stockManagement.size(); i++) {
			JSONObject stockManagementDetails = (JSONObject) stockManagement.get(i);
			 String stockName=(String) stockManagementDetails.get("StockName");
			 if(stockName.equalsIgnoreCase(user.getShareName()))
			 {
			list.add(stockManagementDetails);
			 }
		}
		
	}
	/**
	 * method to remove shares of a company from linked list
	 * @param user
	 * @param fileName
	 */
	public void removeSharesFromLinkedList(UserDTO user)
	{
		JSONArray stockManagement = StockAccountMangementRepo.readFromFile(user.getFileName());
		for (int i = 0; i < stockManagement.size(); i++) {
			JSONObject stockManagementDetails = (JSONObject) stockManagement.get(i);
			String stockName=(String) stockManagementDetails.get("StockName");
			if(stockName.equalsIgnoreCase(user.getShareName()))
			{
				list.remove(stockManagementDetails);
			}
		}
		
	}
	/**
	 * method to print the shares in the list
	 */
	public void printTheSharesInList()
	{
		list.printList();
	}
	
}
