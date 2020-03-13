package com.bridgelabz.designpattern.creational.factorypattren;

public class PC extends Computer{
	private String ram;
	private String hdd;
	private String cpu;
	public PC(String ram,String hdd, String cpu)
	{
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
		}
	//@override
	public String getRAM() {
		return this.ram;
	}
	//@override
	public String getHDD() {
		return this.hdd;
	}
	//@override
	public String getCPU() {
		return this.cpu;
	}
	}
