package co.com.poli.moviesservice.service;

import co.com.poli.moviesservice.entities.Movie;
import java.util.List;

public interface MoviesService {

  void save(Movie movies);
  void delete(Movie movies);
  List<Movie> findAll();
  Movie findById(Long id);

}
