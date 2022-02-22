package co.com.poli.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false, unique = true)
  @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
  private Long id;
  @NotBlank(message = "Nombre no debe estar en blanco")
  @Column(name = "name")
  private String name;
  @NotBlank(message = "Apellido no debe estar en blanco")
  @Column(name = "lastname")
  private String lastname;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User users = (User) o;
    return Objects.equals(id, users.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
