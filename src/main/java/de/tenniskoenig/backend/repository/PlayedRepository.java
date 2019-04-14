package de.tenniskoenig.backend.repository;

import de.tenniskoenig.backend.domain.Played;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayedRepository extends JpaRepository<Played, Long> {
    @Query("select userID, sum(points) from Played group by userID order by userID asc")
    Iterable<Played> getHighscore();
}
