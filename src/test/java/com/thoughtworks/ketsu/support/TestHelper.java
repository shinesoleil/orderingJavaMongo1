package com.thoughtworks.ketsu.support;

import java.util.*;

public class TestHelper {



  public static Map<String, Object> productMap() {
    return new HashMap<String, Object>() {{
      put("name", "desk");
      put("description", "black");
      put("price", 610);
    }};
  }

  public static Map<String, Object> userMap() {
    return new HashMap<String, Object>() {{
      put("name", "firstUser");
    }};
  }

  public static Map<String, Object> orderMap(int productId) {
    return new HashMap<String, Object>() {{
      put("name", "firstOrder");
      put("address", "Beijing");
      put("phone", "13099999999");
      put("order_items", orderItemMapList(productId));
    }};
  }

  public static List<Map<String, Object>> orderItemMapList(int productId) {
    Map<String, Object> item =  new HashMap<String, Object>() {{
      put("product_id", productId);
      put("quantity", 2);
    }};

    return new ArrayList<Map<String, Object>>() {{
      add(item);
    }};
  }

  public static Map<String, Object> paymentMap() {
    return new HashMap<String, Object>() {{
      put("pay_type", "CASH");
      put("amount", 1400);
    }};
  }
}
