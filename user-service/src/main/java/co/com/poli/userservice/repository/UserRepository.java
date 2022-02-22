package co.com.poli.userservice.repository;

import co.com.poli.userservice.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByUser (User user);
  List<User> findAll (User user);
  List<User> findAll (Long id);
  //List<User> findByUser(Long id);
}
