package com.bridgrlabz.stockaccountmanagement.model;

public class StockAccountMangement {
	private String shareName;
	private long numberOfShares;
	private double price;
	private String stockSymbol;
	//generating getters and setters for the above declared varialbles
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public void setNumberOfShares(long numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public String getShareName() {
		return shareName;
	}
	public void setShareName(String shareName) {
		this.shareName = shareName;
	}
	public long getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
