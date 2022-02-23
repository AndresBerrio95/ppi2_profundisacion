package co.com.poli.bookingsservice.repository;


import co.com.poli.bookingsservice.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository  extends JpaRepository<Booking,Long> {
  Booking findBookingByUserId(Long userId);
}
