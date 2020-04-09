package com.bridgelabz.mongodb.client.mongodatabase;
import com.mongodb.client.MongoDatabase; 
/**
 * connecting to mongo data base
 */
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;
public class ConnectToDB {
public static void main(String[] args) {
	//Creating a Mongo client
    MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	//creating credentials
	MongoCredential credential;
	credential=MongoCredential.createCredential("sampleUser","myDb","password".toCharArray());
	System.out.println("Connected to the database sucessfully");
	//Accessing the database
	MongoDatabase database=mongo.getDatabase("myDb");
	System.out.println("Credential::"+credential);
}
}
