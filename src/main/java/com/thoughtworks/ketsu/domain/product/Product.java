package com.thoughtworks.ketsu.domain.product;

import com.mongodb.BasicDBObject;
import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.Map;

public class Product implements Record{
  private String id;
  private String name;
  private String description;
  private double price;

  public Product(String id,String name, String description, double price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public Product(BasicDBObject object) {
    this.id = object.getString("_id");
    this.name = object.getString("name");
    this.description = object.getString("description");
    this.price = object.getDouble("price");
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public Map<String, Object> toRefJson(Routes routes) {
    return null;
  }

  @Override
  public Map<String, Object> toJson(Routes routes) {
    return null;
  }
}
