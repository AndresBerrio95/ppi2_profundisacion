package co.com.poli.showtimesservice.service;


import co.com.poli.showtimesservice.entities.ShowTime;
import java.util.List;

public interface ShowTimesService {

    void save(ShowTime showTimes);
    void delete(ShowTime showTimes);
    List<ShowTime> findAll();
    ShowTime findById(Long id);

}
