package com.thoughtworks.ketsu.domain.user;

import com.mongodb.BasicDBObject;
import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.Map;

public class User implements Record {
  private String id;
  private String name;

  public User(BasicDBObject object) {
    this.id = object.getString("_id");
    this.name = object.getString("name");
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
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
