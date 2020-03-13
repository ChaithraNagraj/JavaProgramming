package com.bridgelabz.deckofcards.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//main mathod 
public class Deck {
	final static Logger logger = Logger.getLogger(Deck.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("logger//log4j.properties");
		 String[] Suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	        String[] value = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	        int totalcount = Suits.length * value.length;
	        String[] deck = new String[totalcount];
	        for (int i = 0; i < value.length; i++) {
	            for (int j = 0; j < Suits.length; j++) {
	                deck[Suits.length * i + j] = value[i] + " " + Suits[j];
	            }
	        }
	        for (int i = 0; i < totalcount; i++) {
	            int r = i + (int) (Math.random() * (totalcount - i));
	            String temp = deck[r];
	            deck[r] = deck[i];
	            deck[i] = temp;
	        }
	        logger.info("Total numver of deck of cards are " + deck.length);
	        for (int i = 0; i <=3; i++) {
	            logger.info("----- Person " + (i + 1) + " -----");
	            for (int j = 0; j <= 8; j++) {
	                logger.info(deck[i + j * 4] + " (Card " + (i + j * 4) + ")");
	            }
	        }
	    }
}
