package co.com.poli.showtimesservice.entities;

import java.util.ArrayList;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "showtimes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    public Long id;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "movies")
    private ArrayList[] movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowTime showTimes = (ShowTime) o;
        return Objects.equals(id, showTimes.id) && Objects.equals(date, showTimes.date) && Objects.equals(movies, showTimes.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, movies);
    }
}
