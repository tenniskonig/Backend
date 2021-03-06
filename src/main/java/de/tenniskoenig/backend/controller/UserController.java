package de.tenniskoenig.backend.controller;

import de.tenniskoenig.backend.domain.User;
import de.tenniskoenig.backend.exception.ResourceNotFoundException;
import de.tenniskoenig.backend.factory.UserFactory;
import de.tenniskoenig.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.attribute.UserDefinedFileAttributeView;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/player", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')or hasAuthority('STANDARD_USER')")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/player/id/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER')or hasAuthority('STANDARD_USER')")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        ;
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/player/name/{username}")
    @PreAuthorize("hasAuthority('ADMIN_USER')or hasAuthority('STANDARD_USER')")
    public ResponseEntity<User> getUserByUserName(@PathVariable(value = "username") String userName) throws ResourceNotFoundException {
        User user = userRepository.findByUsername(userName);
        return ResponseEntity.ok().body(user);
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/player/create")
    public User createUser(@Valid @RequestBody User user) {

        UserFactory.createNewObject();
        UserFactory.setPassword(passwordEncoder.encode(user.getPassword()));

        String tusername = user.getFirstName().toLowerCase() + "." + user.getLastName().toLowerCase();
        UserFactory.setUsername(tusername);
        if(userRepository.findByUsername(tusername)!=null){
            int k = 1;
            while(true){
                if(userRepository.findByUsername(tusername+k)==null){
                    UserFactory.setUsername(tusername+k);
                    break;
                }
                k++;
            }
        }
        UserFactory.setFirstName(user.getFirstName());
        UserFactory.setLastName(user.getLastName());
        UserFactory.setGeschlecht(user.isGeschlechtw());
        return userRepository.save(UserFactory.getObject());
    }
}
