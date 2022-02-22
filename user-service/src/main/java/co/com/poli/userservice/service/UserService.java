package co.com.poli.userservice.service;

import co.com.poli.userservice.entities.User;
import java.util.List;

public interface UserService {

  void save(User users);
  void delete(User users);
  List<User> findAll();
  User findById(Long id);

}
