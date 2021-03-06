package co.com.poli.bookingsservice.controller;

import co.com.poli.bookingsservice.entities.Booking;
import co.com.poli.bookingsservice.helper.ResponseBuilder;
import co.com.poli.bookingsservice.model.Response;
import co.com.poli.bookingsservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    private final ResponseBuilder builder;

  @PostMapping()
  public Response save(@Valid @RequestBody Booking booking, BindingResult result){
    if(result.hasErrors()){
      return builder.failed(formatMessage(result));
    }
    bookingService.save(booking);
    return builder.success(booking);
  }

  @GetMapping
  public Response findAll(){
    List<Booking> bookings = bookingService.findAll();
    if (bookings.isEmpty()){
      return builder.failed("No hay reservaciones");
    }
    return builder.success(bookings);
  }

  @GetMapping("/{id}")
  public Response findById(@PathVariable("id") Long id){
    Booking booking = bookingService.findById(id);
    if(booking==null){
      return builder.failed("Reserva no encontrada");
    }
    return builder.success(booking);
  }

  @DeleteMapping("/{id}")
  public Response delete(@PathVariable("id") Long id){
    Booking booking = bookingService.findById(id);
    if(booking==null){
      return builder.failed("Reserva no encontrada");
    }
    bookingService.delete(booking);
    return builder.success(booking);
  }


  @GetMapping("/userId/{userId}")
  public Response findBookingByUserId(@PathVariable("userId") Long userId){
    Booking booking = bookingService.findBookingByUserId(userId);
    if(booking==null){
      return builder.failed("Reserva no encontrada");
    }
    return builder.success(booking);
  }

    private List<Map<String,String>> formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        return errors;
    }
}
