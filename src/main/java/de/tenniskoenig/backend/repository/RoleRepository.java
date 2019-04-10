package de.tenniskoenig.backend.repository;

import de.tenniskoenig.backend.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
