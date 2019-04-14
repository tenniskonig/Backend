package de.tenniskoenig.backend.controller;

import de.tenniskoenig.backend.domain.Game;
import de.tenniskoenig.backend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tenniskoenig.backend.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping(value ="/match")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public Iterable<Game> getGames(){
        return gameRepository.findAll();
    }

    @GetMapping("/match/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public ResponseEntity<Game> getGameById(@PathVariable(value = "id") Long gameId) throws ResourceNotFoundException {
        Game user = gameRepository.findById(gameId)
                .orElseThrow(()-> new ResourceNotFoundException("Game", "id", gameId));
        return ResponseEntity.ok().body(user);
    }


    @GetMapping("/match/byplayer/{Id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public Iterable<Game> getGameByPlayerId(@PathVariable(value = "Id") Long playerId) throws ResourceNotFoundException {
        return gameRepository.findAllByPlayer1Team1OrPlayer2Team2OrPlayer3Team1OrPlayer4Team2(playerId, playerId, playerId, playerId);
    }
}
