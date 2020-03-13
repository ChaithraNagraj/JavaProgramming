package com.bridgelabz.inventrymanagement.repositry;

import java.util.List;

import org.apache.log4j.Logger;

import com.bridgelabz.inventrymanagement.model.Inventory;
import com.bridgelabz.inventrymanagement.model.InventoryList;
import com.bridgelabz.inventrymanagement.utility.Utility;

public class MethodsofInventoryfile {
	final static Logger logger = Logger.getLogger(MethodsofInventoryfile.class);
	public static Inventory getInventories()
	{
		Inventory inventory = new Inventory();
		logger.info("Enter name of inventory");
		inventory.setName(Utility.readString());
		logger.info("Enter weight of inventory in kilograms");
		inventory.setWeight(Utility.readdouble());
		logger.info("Enter price of inventory in rupees");
		inventory.setPrice(Utility.readdouble());
		return inventory;
	}
	public static InventoryList display(List<InventoryList> list2)
	{
		for (int i = 0; i < list2.size(); i++) {
			InventoryList it = list2.get(i);
			logger.info("Inventory name :" + InventoryList.getInventoryName());
			for (int j = 0; j < it.getListofInventories().size(); j++) {
				logger.info("name :" + it.getListofInventories().get(j).getName());
				logger.info("price :" + it.getListofInventories().get(j).getprice());
				logger.info("weight :" + it.getListofInventories().get(j).getWeight());
				logger.info(" ");
			}
			}
		logger.info("---------------------------------------------");
		return null;
	}


	public static InventoryList insertNewInventory(String inventoryName, List<Inventory> listOfInventories)
	{
		InventoryList inventoryList = new InventoryList();
		inventoryList.setInventoryNmae(inventoryName);
		inventoryList.setListOfInventories(listOfInventories);
		return inventoryList;
	}


	@SuppressWarnings("static-access")
	public static void priceOFInventory(List<InventoryList> originfile)
	{

		for (int i = 0; i < originfile.size(); i++) {
			InventoryList it = originfile.get(i);
			logger.info("Inventory name :" + it.getInventoryName());
			for (int j = 0; j < it.getListofInventories().size(); j++) {
				logger.info("name :" + it.getListofInventories().get(j).getName());
				double sum=it.getListofInventories().get(j).getprice()*it.getListofInventories().get(j).getWeight();
				logger.info("total price to be given is :"+sum);
			}
			logger.info("---------------------------------------------");
		}
	}
}
