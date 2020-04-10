package com.bridgelabz.mongodb.client.mongodatabase;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
/***
*In this class our main intention to in sert the document to our collection
* using insertOne() method
*@author:chaithra B N
*
***/
public class InsertingDocument {
	public static void main( String args[] ) {
		
		// Creating a Mongo client
		@SuppressWarnings("resource")
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		
		// Accessing the database
		MongoDatabase database = mongo.getDatabase("myDb");
		
		// Creating a collection
		database.createCollection("sampleCollection");
		System.out.println("Collection created successfully");
		
		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("sampleCollection");
		System.out.println("Collection sampleCollection selected successfully");
		Document document = new Document("title", "MongoDB")
		.append("description", "database")
		.append("likes", 100)
		.append("url", "http://www.bridgelabz.com/mongodb/")
		.append("by", "emplyomentProvider");
		
		//Inserting document into the collection
		collection.insertOne(document);
		System.out.println("Document inserted successfully");
	}
}
