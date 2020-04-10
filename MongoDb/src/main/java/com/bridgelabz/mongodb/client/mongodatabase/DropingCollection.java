package com.bridgelabz.mongodb.client.mongodatabase;

import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase;  
import org.bson.Document;  
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  

/**
 * To drop a collection from a database  we need to use
 * drop() method 
 * @author chaithra B N
 *
 */
public class DropingCollection {
public static void main(String[] args) {
	//Creating a mongo client
	MongoClient mongo=new MongoClient("localhost",27017);
	
	//Creating Credentials
	MongoCredential credential;
	credential=MongoCredential.createCredential("sampleUser","myDb","password".toCharArray());
	System.out.println("connected to the database successfuly");
	// Accessing the database 
    MongoDatabase database = mongo.getDatabase("myDb");  
    
    // Creating a collection 
    System.out.println("Collections created successfully"); 
    // Retrieving a collection
    MongoCollection<Document> collection = database.getCollection("sampleCollection");
    // Dropping a Collection 
    collection.drop(); 
    System.out.println("Collection dropped successfully");
 } 
}
