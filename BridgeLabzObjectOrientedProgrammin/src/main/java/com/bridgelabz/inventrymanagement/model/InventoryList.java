package com.bridgelabz.inventrymanagement.model;

import java.util.ArrayList;
import java.util.List;

public class InventoryList {
private static String inventoryName;
List<Inventory>listofInventories=new ArrayList<Inventory>();
public static String getInventoryName() {
	return inventoryName;
}
public void setInventoryNmae(String inventoryName) {
	InventoryList.inventoryName=inventoryName;
}
public List<Inventory>getListofInventories(){
	return listofInventories;
}
public void setListOfInventories(List<Inventory> listofInventories) {
	this.listofInventories=listofInventories;
}
}
