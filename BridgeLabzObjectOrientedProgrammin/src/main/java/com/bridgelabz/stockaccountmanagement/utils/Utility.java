package com.bridgelabz.stockaccountmanagement.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utility {
	private static String jsonLocation = "F:\\jsonfiles\\StockAccountManagement\\";

	private Utility() {
	}

	public static File createFile(String fileName) {
		File file = new File(jsonLocation + fileName);
		return file;
	}

	/**
	 * method to create file writer object
	 */
	public static FileWriter createWriterObject(String fileName) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(jsonLocation + fileName + ".json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileWriter;
	}

	/**
	 * method to create file reader object
	 */
	public static FileReader createReaderObject(String fileName) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonLocation + fileName + ".json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileReader;
	}

	/**
	 * method to create Gson Object
	 */
	public static Gson createGsonObject() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		return builder.create();
	}

}
