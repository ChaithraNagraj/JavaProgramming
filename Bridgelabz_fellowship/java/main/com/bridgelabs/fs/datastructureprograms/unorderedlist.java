package com.bridgelabs.fs.datastructureprograms;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabs.fs.datastructureprograms.Node;
import com.bridglabz.utility.InputUtility;
//import java.lang.NullPointerException;

public class unorderedlist {
	final static Logger logger=Logger.getLogger(unorderedlist.class);
	static Node start;
	//Utility  u1=new Utility();
	//ListUtility lu=new ListUtility();

	public static void UnorderedList()
	{
		try
		{
			start=Utility.readFile(start);
			logger.info("Enter the word to search :");
			String word1=InputUtility.stringVal();
			//Search the word
			start=Utility.searchData(start,word1);
			String word2=" ";

			while(start!=null)
			{
				word2=word2+start.data;
				word2=word2+" ";
				start=start.nextNode;
			}
			//  u1.writeToFile(start);
			Utility.writeDataToFile(word2);
		}
		catch(NullPointerException n)
		{
			logger.info(n);
		}
	}  		//End of method

	public static void main(String[] args)
	{
		PropertyConfigurator.configure("src//log4j.properties");
		UnorderedList();
	}
}
