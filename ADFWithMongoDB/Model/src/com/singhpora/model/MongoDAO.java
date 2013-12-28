package com.singhpora.model;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;

import java.util.Arrays;

import oracle.jbo.JboException;


public class MongoDAO {
    
    // or
    private static MongoClient mongoClient;
    
    public MongoDAO() {
        super();
        try {
            mongoClient = new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            throw new JboException(e);
        }
    }
    
    
    public static DB getDB() throws UnknownHostException {
       if(mongoClient == null)
           mongoClient = new MongoClient("localhost", 27017);

        DB db = mongoClient.getDB( "hrdb" );
        return db;
    }

    


    
    
    
    
    
}
