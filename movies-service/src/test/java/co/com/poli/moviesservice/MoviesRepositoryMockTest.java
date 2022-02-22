package co.com.poli.moviesservice;

import co.com.poli.moviesservice.entities.Movie;
import co.com.poli.moviesservice.repository.MoviesRepository;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MoviesRepositoryMockTest {

  @Autowired
  private MoviesRepository moviesRepository;

  @Test
  public void when_findByMovies_return_ListMovies(){
    Movie movie = Movie.builder()
        .title("The Walking dead")
        .director("Juan Perez")
        .rating(4)
        .build();
    moviesRepository.save(movie);
    List<Movie> movies = moviesRepository.findAll();
    Assertions.assertThat(movies.size()).isEqualTo(4);
  }
}
