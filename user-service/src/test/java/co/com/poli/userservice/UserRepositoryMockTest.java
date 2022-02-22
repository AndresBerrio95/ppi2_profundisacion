package co.com.poli.userservice;

import co.com.poli.userservice.entities.User;
import co.com.poli.userservice.repository.UserRepository;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryMockTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void when_findByUsers_return_ListUsers(){
    User user = User.builder()
        .name("Juan")
        .lastname("Perez")
        .build();
    userRepository.save(user);
    List<User> users = userRepository.findAll(user);
    Assertions.assertThat(users.size()).isEqualTo(3);
  }
}
