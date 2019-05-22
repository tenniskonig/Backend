package de.tenniskoenig.backend.repository;

import de.tenniskoenig.backend.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
    /**
     * @param playerId1 Player1 Team1
     * @param playerId2 Player 2 Team2
     * @param playerId3 Player3 Team1
     * @param playerId4 Player4 Team2
     * @return All games by these Users
     */
    Iterable<Game> findAllByPlayer1Team1OrPlayer2Team2OrPlayer3Team1OrPlayer4Team2(int playerId1, int playerId2, int playerId3, int playerId4);
    Game findByGameID(int id);
}
