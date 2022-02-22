package co.com.poli.userservice.service;

import co.com.poli.userservice.entities.User;
import co.com.poli.userservice.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository usersRepository;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void save(User users) {
    usersRepository.save(users);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void delete(User users) {
    usersRepository.delete(users);
  }

  @Override
  @Transactional(readOnly = true)
  public List<User> findAll() {
    return usersRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public User findById(Long id) {
    return usersRepository.findById(id).orElse(null);
  }
}
