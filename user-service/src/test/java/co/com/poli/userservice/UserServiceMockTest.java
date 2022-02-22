package co.com.poli.userservice;

import co.com.poli.userservice.entities.User;
import co.com.poli.userservice.repository.UserRepository;
import co.com.poli.userservice.service.UserService;
import co.com.poli.userservice.service.UserServiceImpl;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceMockTest {

  @Mock
  private UserRepository userRepository;
  private UserService userService;

  @BeforeEach
  public void begin(){
    MockitoAnnotations.openMocks(this);
    userService = new UserServiceImpl(userRepository);
    User user = User.builder()
        .id(4L)
        .name("Juan")
        .lastname("Perez")
        .build();
    Mockito.when(userRepository.findById(4L))
    .thenReturn(Optional.of(user));
  }

  @Test
  public void when_findById_return_User(){
    User user = userService.findById(4L);
    Assertions.assertThat(user.getName()).isEqualTo("Juan");
  }
}
