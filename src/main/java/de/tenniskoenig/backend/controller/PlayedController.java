package de.tenniskoenig.backend.controller;

import de.tenniskoenig.backend.domain.Played;
import de.tenniskoenig.backend.exception.ResourceNotFoundException;
import de.tenniskoenig.backend.repository.PlayedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlayedController {
    @Autowired
    private PlayedRepository playedRepository;


    @GetMapping("/highscore")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public Iterable<Played> getHighscore() throws ResourceNotFoundException {
        return playedRepository.getHighscore();
    }
}
