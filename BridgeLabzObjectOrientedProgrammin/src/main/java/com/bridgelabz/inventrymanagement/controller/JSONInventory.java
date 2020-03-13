package com.bridgelabz.inventrymanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.inventrymanagement.model.Inventory;
import com.bridgelabz.inventrymanagement.model.InventoryList;
import com.bridgelabz.inventrymanagement.repositry.MethodsofInventoryfile;
import com.bridgelabz.inventrymanagement.utility.Utility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;

public class JSONInventory {
	final static Logger logger = Logger.getLogger(JSONInventory.class);
static
String str = "F:\\jsonfiles\\Inventrymanagement\\sample.json";
static ObjectMapper objectMapper=new ObjectMapper();
static  List<InventoryList> originfile=new ArrayList<InventoryList>();
static InventoryList inventoryList=new InventoryList();
static List<Inventory>listOFInventories=new ArrayList<Inventory>();

public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	PropertyConfigurator.configure("logger//log4j.properties");
	String reference = "";
	int z= 0;
	do {
		logger.info("1.Display file\n2.Add to file\n3.Check for price\n4.exit");
		int choice = Utility.readInteger();
		switch (choice)
		{
		case 1:
			reference = Utility.readFile(str);
			try {
				originfile = objectMapper.readValue(reference, new TypeReference<List<InventoryList>>() {});
                MethodsofInventoryfile.display(originfile);
			} catch (Exception e) {
			logger.info("oops nothing is present in the file !! first add inputs on to file or select second choice");
			}
			break;
		case 2:
			String [] arr= {"","rice","wheat","pulses"};
			int ref = 1, flag = 0;
			while (ref == 1) {
			logger.info("Select the inventory name \n 1.rice 2.wheat 3.pulses");
			int inventoryname=Utility.readInteger();
			
			 
				for (InventoryList nameList : originfile) {
					if (arr[inventoryname].equals(InventoryList.getInventoryName())) {
						listOFInventories = nameList.getListofInventories();
						Inventory inventory = MethodsofInventoryfile.getInventories();
						listOFInventories.add(inventory);
						flag = 1;
					}
				}
				if (flag == 0) {
					Inventory inventory =MethodsofInventoryfile.getInventories();
					listOFInventories.add(inventory);
					inventoryList = MethodsofInventoryfile.insertNewInventory(arr[inventoryname], listOFInventories);
					originfile.add(inventoryList);
				}
				logger.info("wish to add some more inventorry(1 or 0)");
				ref = Utility.readInteger();
				
				
			}
			logger.info("Entered elements has been added to list");
			String json = objectMapper.writeValueAsString(originfile);
			Utility.writelist(json);
			logger.info("Inventory list has been written on to file");
			break;
		case 3:
			reference = Utility.readFile(str);
			originfile = objectMapper.readValue(reference, new TypeReference<List<InventoryList>>() {});
			MethodsofInventoryfile.priceOFInventory(originfile);
			break;
		case 4:
			System.exit(0);
			break;
		default:
			logger.info("please select valid input");
			break;
		}
		logger.info("Press 1 to continue");
		z=Utility.readInteger();
		z++;
	}  while (z<100);
}
}

