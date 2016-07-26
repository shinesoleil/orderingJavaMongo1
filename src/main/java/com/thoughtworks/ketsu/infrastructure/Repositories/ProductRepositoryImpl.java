package com.thoughtworks.ketsu.infrastructure.Repositories;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.thoughtworks.ketsu.domain.product.Product;
import com.thoughtworks.ketsu.domain.product.ProductRepository;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

  @Inject
  DB db;

  @Override
  public Optional<Product> create(Map<String, Object> info) {
    DBCollection table = db.getCollection("products");

    BasicDBObject document = new BasicDBObject();
    document.put("name", String.valueOf(info.get("name")));
    document.put("description", String.valueOf(info.get("description")));
    document.put("price", Double.valueOf(String.valueOf(info.get("price"))));

    table.insert(document);
    ObjectId id = new ObjectId(String.valueOf(document.get("_id")));
    info.put("id", id);

    BasicDBObject searchQuery = new BasicDBObject();
    searchQuery.put("_id", id);

    DBCursor cursor = table.find(searchQuery);

    if (cursor.hasNext()) {
      return Optional.ofNullable(new Product((BasicDBObject) cursor.next()));
    } else {
      return null;
    }
  }

  @Override
  public Optional<Product> findById(String id) {
    DBCollection table = db.getCollection("products");

    BasicDBObject searchQuery = new BasicDBObject();
    searchQuery.put("_id", new ObjectId(id));
    DBCursor cursor = table.find(searchQuery);

    if (cursor.hasNext()) {
      return Optional.ofNullable(new Product((BasicDBObject) cursor.next()));
    } else {
      return Optional.ofNullable(null);
    }

  }

  @Override
  public List<Product> find() {
    List<Product> productList = new ArrayList();
    DBCollection table = this.db.getCollection("products");

    DBCursor cursor = table.find();

    if (cursor.hasNext()) {
      productList.add(new Product((BasicDBObject) cursor.next()));
    }

    return productList;
  }
}
