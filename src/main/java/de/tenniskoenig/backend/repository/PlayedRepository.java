package de.tenniskoenig.backend.repository;

import de.tenniskoenig.backend.domain.Played;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayedRepository extends JpaRepository<Played, Long> {
    @Query("select p.userID, sum(p.points), count(p) from Played p group by p.userID order by p.userID asc")
    Iterable<Played> getHighscore();
}
