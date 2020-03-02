package com.bridgelabs.fs.logicalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;

	public class TicTacToe{
		final static Logger logger = Logger.getLogger(TicTacToe.class);

		public static void main(String args[])
	    {
			PropertyConfigurator.configure("src//log4j.properties");

	        String ch;
	        //TicTacToe Toe=new TicTacToe();
	        do{
	            //Toe.newBoard();
	        	Utility.newBoard();
	            Utility.play();
	            System.out.println ("Would you like to play again (Enter 'yes')? ");
	            //Scanner in =new Scanner(System.in);
	            //ch=in.nextLine();
	             ch=InputUtility.stringVal();
	            logger.info("ch value is  "+ch);
	        }while (ch.equals("yes"));
	        
	    }
		}