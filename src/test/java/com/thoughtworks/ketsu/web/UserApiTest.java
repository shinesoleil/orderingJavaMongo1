package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;

@RunWith(ApiTestRunner.class)
public class UserApiTest extends ApiSupport{

  @Test
  public void should_return_201_when_post_user() {
    Response post = post("users", new HashMap());

  }
}
