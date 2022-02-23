package co.com.poli.bookingsservice.service;

import co.com.poli.bookingsservice.client.MoviesClient;
import co.com.poli.bookingsservice.client.UserClient;
import co.com.poli.bookingsservice.entities.Booking;
import co.com.poli.bookingsservice.entities.MoviesItems;
import co.com.poli.bookingsservice.model.Movies;
import co.com.poli.bookingsservice.model.User;
import co.com.poli.bookingsservice.repository.BookingRepository;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl  implements  BookingService{

    private final BookingRepository bookingRepository;
    private final UserClient userClient;
    private final MoviesClient moviesClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Booking findById(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userClient.findById(booking.getId()).getData(),User.class);
        booking.setUser(user);
        List<MoviesItems> moviesItems = booking.getMovies().stream()
            .map(movieItem -> {
                Movies movies = modelMapper.map(moviesClient.findById(movieItem.getId()).getData(),Movies.class);
                movieItem.setMoviesItems(movies);
                return movieItem;
            }).collect(Collectors.toList());
        return bookingRepository.findById(id).orElse(null);
    }


    @Override
    @Transactional(readOnly = true)
    public Booking findBookingByUserId(Long id) {
        Booking booking = bookingRepository.findBookingByUserId(id);
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userClient.findById(booking.getId()).getData(),User.class);
        booking.setUser(user);
        return bookingRepository.findBookingByUserId(id);
    }
}