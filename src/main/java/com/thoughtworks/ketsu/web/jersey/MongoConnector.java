package com.thoughtworks.ketsu.web.jersey;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class MongoConnector {

  private static DB db;
  private static MongoClient mongo = null;

  public static void init() {
    try {
      mongo = new MongoClient("localhost", 27017);
    } catch (final UnknownHostException e) {
      System.out.println("Erro!!!!");
    }
    db = mongo.getDB("log");
  }

  public static DB getDb() {
    return db;
  }

  public static void close() {
    mongo.close();
  }

}