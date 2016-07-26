package com.thoughtworks.ketsu.infrastructure.records;

import com.google.inject.AbstractModule;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;

public class MongoModels extends AbstractModule {
  @Override
  protected void configure() {
    String dbname = System.getenv().getOrDefault("MONGODB_DATABASE", "mongodb_store");
    String host = System.getenv().getOrDefault("MONGODB_HOST", "localhost");
    String user = System.getenv().getOrDefault("MONGODB_USER", "admin");
    String password = System.getenv().getOrDefault("MONGODB_PASS", "mypass");

    MongoClient mongoClient = null;

    try {
      mongoClient =
        new MongoClient(
          new MongoClientURI(String.format("mongodb://%s:%s@%s/%s", user, password, host, dbname))
        );
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }

    DB db = mongoClient.getDB("mongodb_store");
    bind(DB.class).toInstance(db);

  }
}
