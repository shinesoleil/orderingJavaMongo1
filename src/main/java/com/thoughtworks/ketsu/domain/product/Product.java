package com.thoughtworks.ketsu.domain.product;

import com.mongodb.BasicDBObject;

public class Product {
  private String name;
  private String description;
  private double price;

  public Product(String name, String description, double price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public Product(BasicDBObject object) {
    this.name = object.getString("name");
    this.description = object.getString("description");
    this.price = object.getDouble("price");
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
}
