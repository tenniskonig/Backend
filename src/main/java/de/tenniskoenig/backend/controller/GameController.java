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

    @GetMapping(value ="/games")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public Iterable<Game> getGames(){
        return gameRepository.findAll();
    }

    @GetMapping("/games/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<Game> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        Game user = gameRepository.findGameByGameID(userId);
        return ResponseEntity.ok().body(user);
    }
}
