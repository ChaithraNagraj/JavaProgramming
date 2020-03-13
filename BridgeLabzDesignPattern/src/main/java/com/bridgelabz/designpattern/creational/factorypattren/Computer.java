package com.bridgelabz.designpattern.creational.factorypattren;

public abstract class Computer {
public  abstract String getRAM();
public abstract String getHDD();
public abstract String getCPU();
//public abstract String getPRICE();

//@override
public String toString() {
	return "RAM="+this.getRAM()+",HDD="+this.getHDD()+",CPU="+this.getCPU();
	//+",PRICE="+this.getPRICE();
}
}