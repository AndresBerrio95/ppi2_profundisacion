package co.com.poli.moviesservice.controller;

import co.com.poli.moviesservice.entities.Movie;
import co.com.poli.moviesservice.helper.ResponseBuilder;
import co.com.poli.moviesservice.model.Response;
import co.com.poli.moviesservice.service.MoviesService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {

  private final MoviesService moviesService;
  private final ResponseBuilder builder;

  @PostMapping
  public Response save(@Valid @RequestBody Movie movie, BindingResult result){
    if (result.hasErrors()){
      return builder.failed(formatMessage(result));
    }
    moviesService.save(movie);
    return builder.success(movie);
  }

  @DeleteMapping("/{id}")
  public Response delete(@PathVariable("id") Long id){

    Movie movie = moviesService.findById(id);
    if (movie == null){
      return builder.failed("No found movie");
    }
    moviesService.delete(movie);
    return builder.success(movie);
  }

  @GetMapping
  public Response findAll(){
    List<Movie> movie = moviesService.findAll();
    if (movie.isEmpty()){
      return builder.failed("Movie is empty");
    }
    return builder.success(movie);
  }

  @GetMapping("/{id}")
  public Response findById(@PathVariable("id") Long id){
    Movie movie = moviesService.findById(id);
    if (movie == null){
      return builder.failed("No found movie");
    }
    return builder.success(movie);
  }


  private  List<Map<String,String>> formatMessage(BindingResult result){
    List<Map<String,String>> errors = result.getFieldErrors().stream()
        .map(err -> {
          Map<String,String> error = new HashMap<>();
          error.put(err.getField(),err.getDefaultMessage());
          return error;
        }).collect(Collectors.toList());
    return errors;
  }

}
