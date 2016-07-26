package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.UserRepository;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class UserRepositoryTest{

  @Inject
  UserRepository userReopsitory;

  @Test
  public void should_create_user_and_find_user_by_id() {
    Map<String, Object> info = TestHelper.userMap();

    userReopsitory.create(info);
    String id = String.valueOf(info.get("id"));
    User user = userReopsitory.findById(id).get();

    assertThat(user.getName(), is("firstUser"));
  }
}
