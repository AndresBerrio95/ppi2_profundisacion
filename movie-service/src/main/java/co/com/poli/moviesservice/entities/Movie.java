package co.com.poli.moviesservice.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false, unique = true)
  private Long id;
  @NotBlank(message = "Titulo no debe estar en blanco")
  @Column(name = "title")
  private String title;
  @NotBlank(message = "Director no debe estar en blanco")
  @Column(name = "director")
  private String director;
  @Range(min = 1, max = 5, message = "El rango debe estar entre 1 y 5 caracteres")
  @Column(name = "rating")
  private int rating;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Movie movies = (Movie) o;
    return Objects.equals(id, movies.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
