package com.bridgelabz.mongodb.client.mongodatabase;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

/**
 * in this example we are creating a collection, to that we
 *  are using createCllection() method is using
 * @author chaithra
 *
 */
public class CreatingCollection {
public static void main(String[] args) {
	//Creating a mongo client
	MongoClient mongo=new MongoClient("localhost",27017);
	//Creating Credentials
	MongoCredential credential;
	credential = MongoCredential.createCredential("sampleuser", "myDb","password".toCharArray());
	System.out.println("Connected to the database successfully");
	
	//Accessing the database
	MongoDatabase database=mongo.getDatabase("myDb");
	
	//Creating a collection
	database.createCollection("sampleCollection");
	System.out.println("Collection created successfully");
	
	}
}
