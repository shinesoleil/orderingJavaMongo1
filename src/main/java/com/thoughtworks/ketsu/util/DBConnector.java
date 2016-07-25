package com.thoughtworks.ketsu.util;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;

public class DBConnector {

  public static DB getDBConnection() throws UnknownHostException {
    String dbname = System.getenv().getOrDefault("MONGODB_DATABASE", "mongodb_store");
    String host = System.getenv().getOrDefault("MONGODB_HOST", "localhost");
    String user = System.getenv().getOrDefault("MONGODB_USER", "admin");
    String password = System.getenv().getOrDefault("MONGODB_PASS", "mypass");

    MongoClient mongoClient = new MongoClient(
      new MongoClientURI(String.format("mongodb://%s:%s@%s/%s", user, password, host, dbname ))
    );

    return mongoClient.getDB("mongodb_store");
  }
}
