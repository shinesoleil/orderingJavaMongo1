package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.product.Product;
import com.thoughtworks.ketsu.domain.product.ProductRepository;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class ProductRepositoryTest {

  @Inject
  ProductRepository productRepository;


  @Test
  public void should_create_and_find_product_by_id(){
    Map<String, Object> info = TestHelper.productMap();

    productRepository.create(info);

    Product product = productRepository.findById(String.valueOf(info.get("id"))).get();

    assertThat(product.getName(), is("desk"));
  }
}
