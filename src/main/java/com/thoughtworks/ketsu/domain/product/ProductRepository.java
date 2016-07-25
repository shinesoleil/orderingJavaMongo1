package com.thoughtworks.ketsu.domain.product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductRepository {
  Optional<Product> create(Map<String, Object> info);

  Optional<Product> findById(String id);

  List<Product> find();
}
