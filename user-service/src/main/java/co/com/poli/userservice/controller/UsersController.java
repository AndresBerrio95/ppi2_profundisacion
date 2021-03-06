package co.com.poli.userservice.controller;

import co.com.poli.userservice.entities.User;
import co.com.poli.userservice.helper.ResponseBuilder;
import co.com.poli.userservice.model.Response;
import co.com.poli.userservice.service.UserService;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

  private final UserService usersService;
  private final ResponseBuilder builder;

  @PostMapping
  public Response save(@Valid @RequestBody User user, BindingResult result){
    if (result.hasErrors()){
      return builder.failed(formatMessage(result));
    }
    usersService.save(user);
    return builder.success(user);
  }

  @DeleteMapping("/{id}")
  public Response delete(@PathVariable("id") Long id){
    User user = usersService.findById(id);
    if (user == null){
      return builder.failed("No found user");
    }
    usersService.delete(user);
    return builder.success(user);
  }

  @GetMapping
  public Response findAll(){
    List<User> user = usersService.findAll();
    if (user.isEmpty()){
      return builder.failed("Users is empty");
    }
    return builder.success(user);
  }

  @GetMapping("/{id}")
  public Response findById(@PathVariable("id") Long id){
    User user = usersService.findById(id);
    if (user == null){
      return builder.failed("No found user");
    }
    return builder.success(user);
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
