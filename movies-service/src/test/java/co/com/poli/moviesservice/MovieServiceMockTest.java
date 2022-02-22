package co.com.poli.moviesservice;

import co.com.poli.moviesservice.entities.Movie;
import co.com.poli.moviesservice.repository.MoviesRepository;
import co.com.poli.moviesservice.service.MoviesService;
import co.com.poli.moviesservice.service.MoviesServiceImpl;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieServiceMockTest {

  @Mock
  private MoviesRepository moviesRepository;
  private MoviesService moviesService;

  @BeforeEach
  public void begin(){
    MockitoAnnotations.openMocks(this);
    moviesService = new MoviesServiceImpl(moviesRepository);
    Movie movie = Movie.builder()
        .id(4L)
        .title("El patron")
        .director("Familia Berrio Galeano")
        .rating(4)
        .build();
    Mockito.when(moviesRepository.findById(4L))
    .thenReturn(Optional.of(movie));
  }

  @Test
  public void when_findById_return_Movie(){
    Movie movie = moviesService.findById(4L);
    Assertions.assertThat(movie.getTitle()).isEqualTo("El patron");
  }
}
