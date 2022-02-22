package co.com.poli.showtimesservice.repository;

import co.com.poli.showtimesservice.entities.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ShowTimesRepository extends JpaRepository<ShowTime,Long> {
}
