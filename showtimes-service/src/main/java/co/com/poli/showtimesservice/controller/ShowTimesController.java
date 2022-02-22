package co.com.poli.showtimesservice.controller;

import co.com.poli.showtimesservice.entities.ShowTime;
import co.com.poli.showtimesservice.helper.ResponseBuilder;
import co.com.poli.showtimesservice.model.Response;
import co.com.poli.showtimesservice.service.ShowTimesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowTimesController {

    private final ShowTimesService showTimesService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@RequestBody ShowTime showtimes) {
        showTimesService.save(showtimes);
        return builder.success(showtimes);
    }

    @GetMapping
    public List<ShowTime> findAll() {
        return showTimesService.findAll();
    }

    @GetMapping("/{id}")
    public ShowTime findById(@PathVariable("id") Long id) {
        return showTimesService.findById(id);
    }

}