package de.tenniskoenig.backend.service.impl;

import de.tenniskoenig.backend.domain.User;
import de.tenniskoenig.backend.repository.UserRepository;
import de.tenniskoenig.backend.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericServiceImpl implements GenericService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }
}
