package com.bridgelabz.stockaccountmanagement.repo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.stockaccountmanagement.utils.Utility;
import com.google.gson.Gson;

public class StockAccountMangementRepo {
	static Gson gson = Utility.createGsonObject();

	/**
	 * method to write JSONArray to file
	 * 
	 * @param object
	 */
	public static void writeToFile(JSONArray array, String fileName) {
		FileWriter fileWriter = Utility.createWriterObject(fileName);
		String json = gson.toJson(array);
		try {
			fileWriter.write(json);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to read data from file
	 * 
	 * @return String
	 */
	public static JSONArray readFromFile(String fileName) {
		FileReader reader = Utility.createReaderObject(fileName);
		JSONParser parser = new JSONParser();
		JSONArray array = null;
		try {
			Object obj = parser.parse(reader);
			array = (JSONArray) obj;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return array;
	}

}
