package com.bridgelabz.mongodb.client.mongodatabase;
/**
 * in this method we select a collection from the database, usring a method called getCollection()
 * 
 * @author chaithra
 *
 */

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

public class SelectingCollection {
public static void main(String[] args) {
	//Creating a mongo client
	@SuppressWarnings("resource")
	MongoClient mongo=new MongoClient("localhost",27017);
	MongoCredential.createCredential("sampleUser","myDb","passoword".toCharArray());
	System.out.println("Connected to the database successfully");  
    
    // Accessing the database 
    MongoDatabase database = mongo.getDatabase("myDb");  
    
    // Creating a collection 
    System.out.println("Collection created successfully"); 
    database.getCollection("myCollection"); 
    System.out.println("Collection myCollection selected successfully"); 
 }

}

