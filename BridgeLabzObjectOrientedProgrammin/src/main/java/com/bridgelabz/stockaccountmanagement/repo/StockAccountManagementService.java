package com.bridgelabz.stockaccountmanagement.repo;

import com.blz.fs.userdefinedexception.CustomizedException;
import com.bridgrlabz.stockaccountmanagement.model.UserDTO;

public interface StockAccountManagementService {
	public void createStockManagement(UserDTO user);

	public void soldStock(UserDTO user) throws CustomizedException;

	public void updateboughtstock(UserDTO user) throws CustomizedException;

	public void updateSoldStock(UserDTO user) throws CustomizedException;

	public void boughtStock(UserDTO user) throws CustomizedException;

	public boolean isStockEmpty(UserDTO user);

	public void printStockDetails(UserDTO user);

}
