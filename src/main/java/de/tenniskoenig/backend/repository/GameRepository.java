package de.tenniskoenig.backend.repository;

import de.tenniskoenig.backend.domain.Game;
import org.springframework.boot.actuate.autoconfigure.metrics.export.ganglia.GangliaMetricsExportAutoConfiguration;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
    Game findGameByGameID(Long gameId);
}
