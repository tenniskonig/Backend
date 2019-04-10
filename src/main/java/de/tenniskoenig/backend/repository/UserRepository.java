package de.tenniskoenig.backend.repository;

import de.tenniskoenig.backend.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
