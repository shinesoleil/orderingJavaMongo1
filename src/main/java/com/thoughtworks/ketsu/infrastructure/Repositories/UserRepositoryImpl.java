package com.thoughtworks.ketsu.infrastructure.Repositories;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.UserRepository;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

  @Inject
  DB db;

  @Override
  public Optional<User> create(Map<String, Object> info) {
    DBCollection table = db.getCollection("users");
    DBObject document = new BasicDBObject();
    document.put("name", String.valueOf(info.get("name")));

    table.insert(document);
    ObjectId id = new ObjectId(String.valueOf(document.get("_id")));
    info.put("id", id);

    DBObject searchQuery = new BasicDBObject() {{
      put("_id", id);
    }};
    return Optional.ofNullable(new User((BasicDBObject) table.findOne(searchQuery)));
  }

  @Override
  public Optional<User> findById(String id) {
    DBCollection table = db.getCollection("users");
    DBObject searchQuery = new BasicDBObject() {{
      put("_id", new ObjectId(id));
    }};
    return Optional.ofNullable(new User((BasicDBObject) table.findOne(searchQuery)));

  }
}
