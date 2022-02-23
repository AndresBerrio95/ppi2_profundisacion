package co.com.poli.bookingsservice.entities;

import co.com.poli.bookingsservice.model.User;
import java.util.List;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;
    @Column(name = "user_Id")
    private Long userId;
    @Transient
    private User user;
    @Column(name = "show_time_id")
    private Long showTimeId;

    @Column(name = "movies")
    private List<MoviesItems> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(userId, booking.userId) && Objects.equals(showTimeId, booking.showTimeId) && Objects.equals(movies, booking.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, showTimeId, movies);
    }
}
