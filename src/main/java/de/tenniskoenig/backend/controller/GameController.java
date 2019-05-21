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


    private void createPlayer(int gameID, int userID, int points) {
        Played played = new Played();
        played.setGameID(gameID);
        played.setUserID(userRepository.findById(userID));
        played.setPoints(points);
    }

    @PostMapping("/match")
    public Game createGame(@Valid @RequestBody Game game) {


        if (game.getPlayTime() == null) {
            if (game.getPlayer1Team1() != 0) {

            }
            if (game.getPlayer2Team2() != 0) {

            }
            if (game.getPlayer3Team1() != 0) {

            }
            if (game.getPlayer4Team2() != 0) {

            }
        }
        return gameRepository.save(game);
    }
}
