package co.com.poli.bookingsservice.service;

import co.com.poli.bookingsservice.entities.Booking;
import java.util.List;

public interface BookingService {
    void save(Booking booking);
    void delete(Booking booking);
    List<Booking> findAll();
    Booking findById(Long id);
}
