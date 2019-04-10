package de.tenniskoenig.backend.service;

import de.tenniskoenig.backend.domain.User;

import java.util.List;

public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();
}
