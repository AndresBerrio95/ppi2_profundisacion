package co.com.poli.moviesservice.service;

import co.com.poli.moviesservice.entities.Movies;
import co.com.poli.moviesservice.repository.MoviesRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MoviesServiceImpl implements MoviesService{

  private final MoviesRepository moviesRepository;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void save(Movies movies) {
    moviesRepository.save(movies);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void delete(Movies movies) {
    moviesRepository.delete(movies);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Movies> findAll() {
    return moviesRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Movies findById(Long id) {
    return moviesRepository.findById(id).orElse(null);
  }
}
