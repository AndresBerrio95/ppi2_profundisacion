package co.com.poli.moviesservice.repository;

import co.com.poli.moviesservice.entities.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movie,Long> {
  List<Movie> findAll ();
}
