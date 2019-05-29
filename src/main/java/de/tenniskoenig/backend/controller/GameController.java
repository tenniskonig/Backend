package de.tenniskoenig.backend.controller;

import de.tenniskoenig.backend.domain.Game;
import de.tenniskoenig.backend.domain.Played;
import de.tenniskoenig.backend.exception.ResourceNotFoundException;
import de.tenniskoenig.backend.repository.GameRepository;
import de.tenniskoenig.backend.repository.PlayedRepository;
import de.tenniskoenig.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayedRepository playedRepository;

    @GetMapping(value = "/match")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public Iterable<Game> getGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/match/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public ResponseEntity<Game> getGameById(@PathVariable(value = "id") Long gameId) throws ResourceNotFoundException {
        Game user = gameRepository.findById(gameId)
                .orElseThrow(() -> new ResourceNotFoundException("Game", "id", gameId));
        return ResponseEntity.ok().body(user);
    }


    @GetMapping("/match/byplayer/{Id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public Iterable<Game> getGameByPlayerId(@PathVariable(value = "Id") Long playerId) throws ResourceNotFoundException {
        return gameRepository.findAllByPlayer1Team1OrPlayer2Team2OrPlayer3Team1OrPlayer4Team2(playerId, playerId, playerId, playerId);
    }


    private void createPlayer(Game game, int userID, int points) {
        Played played = new Played();
        played.setGameID(game);
        played.setUserID(userRepository.findById(userID));
        played.setPoints(points);
    }

    @PostMapping("/match")
    public Game createGame(@Valid @RequestBody Game game) {
        game = gameRepository.save(game);
        int points = 0;
        if (game.getPlayTime() != null) {
            points = getPoints(game.getPlayTime().getMinutes(), game.getPlayTime().getHours());
        }

        if (game.getPlayer1Team1() != 0) {
            Played played = createPlayed(game, game.getPlayer1Team1(), points);
            playedRepository.save(played);
        }
        if (game.getPlayer2Team2() != 0) {
            Played played = createPlayed(game, game.getPlayer2Team2(), points);
            playedRepository.save(played);
        }
        if (game.getPlayer3Team1() != 0) {
            Played played = createPlayed(game, game.getPlayer3Team1(), points);
            playedRepository.save(played);
        }
        if (game.getPlayer4Team2() != 0) {
            Played played = createPlayed(game, game.getPlayer4Team2(), points);
            playedRepository.save(played);
        }
        return game;
    }

    private Played createPlayed(Game gameId,int userId, int points) {
        Played played = new Played();
        played.setUserID(userRepository.findById(userId));
        played.setGameID(gameId);
        played.setPoints(points);
        return played;
    }

    private int getPoints(int minutes, int hour) {
        int points = 0;
        if (hour >= 1) {
            points = 8;
        } else {
            if (minutes >= 15) {
                points = 2;
            } else if (minutes >= 30) {
                points = 4;
            } else if (minutes >= 45) {
                points = 6;
            }
        }
        return points;
    }
}
