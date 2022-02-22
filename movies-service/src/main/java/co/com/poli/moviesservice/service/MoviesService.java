package co.com.poli.moviesservice.service;

import co.com.poli.moviesservice.entities.Movies;
import java.util.List;

public interface MoviesService {

  void save(Movies movies);
  void delete(Movies movies);
  List<Movies> findAll();
  Movies findById(Long id);

}
