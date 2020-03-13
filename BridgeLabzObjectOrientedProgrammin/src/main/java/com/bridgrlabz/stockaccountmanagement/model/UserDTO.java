package com.bridgrlabz.stockaccountmanagement.model;

public class UserDTO {
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private String shareName;
	private long numberOfSharesBought;
	private long numberOfSharesSold;
	private double boughtPrice;
	private double soldPrice;
	private String stockSymbol;

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public long getNumberOfSharesBought() {
		return numberOfSharesBought;
	}

	public void setNumberOfSharesBought(long numberOfSharesBought) {
		this.numberOfSharesBought = numberOfSharesBought;
	}

	public long getNumberOfSharesSold() {
		return numberOfSharesSold;
	}

	public void setNumberOfSharesSold(long numberOfSharesSold) {
		this.numberOfSharesSold = numberOfSharesSold;
	}

	public double getBoughtPrice() {
		return boughtPrice;
	}

	public void setBoughtPrice(double boughtPrice) {
		this.boughtPrice = boughtPrice;
	}

	public double getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

}
