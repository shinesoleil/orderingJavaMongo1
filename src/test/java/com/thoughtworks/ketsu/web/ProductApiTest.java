package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.product.ProductRepository;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class ProductApiTest extends ApiSupport{

  @Inject
  ProductRepository productRepository;

  @Test
  public void should_return_uri_in_location_when_post_product_with_parameters() {
    Map<String, Object> info = TestHelper.productMap();

    Response post = post("products", info);

    assertThat(post.getStatus(), is(201));
    assertThat(Pattern.matches(".*products/[0-9a-z]+.*", post.getLocation().toASCIIString()), is(true));
  }

  @Test
  public void should_return_400_when_post_product_with_invalid_params() {
    Map<String, Object> info = TestHelper.productMap();
    info.replace("name", null);

    Response post = post("products", info);

    assertThat(post.getStatus(), is(400));
  }

  @Test
  public void should_return_list_of_product_when_get_products() {
    Map<String, Object> info = TestHelper.productMap();
    productRepository.create(info);

    Response get = get("products");
    List<Map<String, Object>> productList = get.readEntity(List.class);

    assertThat(productList.size(), is(1));
    assertThat(productList.get(0).get("name"), is("desk"));
  }

  @Test
  public void should_return_product_json_when_get_product_by_id() {
    Map<String, Object> info = TestHelper.productMap();
    productRepository.create(info);
    String id = String.valueOf(info.get("id"));

    Response get = get("products/" + id);
    Map<String, Object> productMap = get.readEntity(Map.class);

    assertThat(get.getStatus(), is(200));
    assertThat(productMap.get("name"), is("desk"));
  }

  @Test
  public void should_return_404_when_get_product_by_id_fails() {
    String id = ObjectId.createFromLegacyFormat(1,1,1).toString();
    Response get = get("products/" + id);

    assertThat(get.getStatus(), is(404));
  }

}
