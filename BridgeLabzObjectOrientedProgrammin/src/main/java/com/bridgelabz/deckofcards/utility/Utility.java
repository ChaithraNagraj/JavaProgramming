package com.bridgelabz.deckofcards.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.gson.JsonParseException;

public class Utility {

	static Scanner scanner1=new Scanner(System.in); //scanner class declaration

	//method for scanner class of integer type 
	/**
	 * static function to read integers input from the user
	 * @return integer values that are read
	 */
	public static int readInteger() {
		return scanner1.nextInt();}

	//method for scanner class of double type 
	/**
	 * static function to read double input from the user
	 * @return double values that are read
	 */
	public static double readdouble() {
		return scanner1.nextDouble();}

	//method for scanner class of long type 
	/**
	 * static function to read long input from the user
	 * @return double values that are read
	 */
	public static long readlong() {
		return scanner1.nextLong();}
	//method for scanner class of String type 
	/**
	 * static function to read string input from the user
	 * @return strings that are read
	 */
	public static String readString() {
		return scanner1.next();}


	/**
	 * static function to read boolean input from the user
	 * @return boolean values that are read
	 */
	public static boolean userBoolean(){
		return scanner1.nextBoolean();}

	public static String readFile(String message) throws FileNotFoundException {
		FileReader f = new FileReader(message);
		@SuppressWarnings("resource")
		BufferedReader read = new BufferedReader(f);
		String line = "";
		try {
			String word="";
			while ((word = read.readLine()) != null) {
				line = word;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}
	//Regex

	public static String modifiedMessage(String name,String fullname,String mobileno, String date,String Message) {
		final String Regex_1="<{2}+\\\\w+>{2}";
		final String Regex_2="<{2}+\\\\w+ +\\\\w+>{2}";
		final String Regex_3="<{2}+x{10}+>{2}";
		final String Regex_4="\\d{2}+/+\\d{2}+/+\\d{4}";			
		

		Pattern p = Pattern.compile(Regex_1);
		Matcher m = p.matcher(Message);
		Message = m.replaceAll(name);

		Pattern p1=Pattern.compile(Regex_2);
		Matcher m1=p1.matcher(Message);
		Message = m1.replaceAll(fullname);

		Pattern p2=Pattern.compile(Regex_3);
		Matcher m2=p2.matcher(Message);
		Message = m2.replaceAll(mobileno);

		Pattern p3=Pattern.compile(Regex_4);
		Matcher m3=p3.matcher(Message);
		Message = m3.replaceAll(date);

		return Message;
	}

	//		

	public static String currentDate()
	{
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate= formatter.format(date);
		return strDate;
	}

		public static void writelist(String json) throws IOException
	{
		FileWriter file = new FileWriter("/home/admin1/Desktop/JSONInventoryDataManagement.json");
		@SuppressWarnings("resource")
		BufferedWriter buffer = new BufferedWriter(file);
		buffer.write(json);
		buffer.flush();
	}

	public static void writeFile(String json,String fileName) throws IOException
	{
		FileWriter fw = new FileWriter(fileName);
		@SuppressWarnings("resource")
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(json);
		bw.flush();
	}

	public static Date printDate(String date) throws java.text.ParseException, ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		return sdf.parse(date);
}
	
	public static <T extends Comparable<T>> T[] sortArray(T str[]) {
	        int length = str.length;
	        for (int i = 1; i < length; i++) {
	            T key = str[i];
	            int j = i - 1;
	            while (j >= 0 && ((str[j].compareTo(key) > 0))) {
	                str[j + 1] = str[j];
	                j--;
	            }
	            str[j + 1] = key;
	        }
	        return str;
	    }
static ObjectMapper objectMapper=new ObjectMapper();

public static <T> List<T> userReadValue(String str, Class<T> cls)
        throws JsonParseException, JsonMappingException, IOException {
    CollectionType colletion = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, cls);
    return objectMapper.readValue(str, colletion);
}

public static <T> String userWriteValueAsString(List<T> tempstocklist)
        throws JsonGenerationException, JsonMappingException, IOException {
    return objectMapper.writeValueAsString(tempstocklist);
}
public static <T> String userWriteValueAsString1(Set<T> set)
        throws JsonGenerationException, JsonMappingException, IOException {
    return objectMapper.writeValueAsString(set);
}

public static <T> List<T> userReadValue1(String str, Class<?> cls)
        throws JsonParseException, JsonMappingException, IOException {
    CollectionType colletion = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, cls);
    return objectMapper.readValue(str, colletion);
}
public static <T> T convertJsonToPOJO(String filePath, Class<?> target) throws JsonParseException, JsonMappingException, IOException, ClassNotFoundException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(new File(filePath), objectMapper .getTypeFactory().constructCollectionType(List.class, Class.forName(target.getName())));
}
}