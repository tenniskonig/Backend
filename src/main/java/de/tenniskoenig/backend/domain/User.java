package de.tenniskoenig.backend.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    public User() {
    }

    @JsonCreator
    public User(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("admin") boolean admin, @JsonProperty("geschlechtw") boolean geschlechtw, @JsonProperty("password") String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;
        this.geschlechtw = geschlechtw;
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        this.password = hashedPassword ;
        this.username = firstName.toLowerCase()+"."+lastName.toLowerCase();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    @JsonIgnore
    private String username;

    @Column(name = "password")
    @JsonSetter
    private String password;

    @Column(name = "vorname")
    private String firstName;

    @Column(name = "nachname")
    private String lastName;

    @Column(name = "admin")
    private boolean admin;

    @Column(name = "geschlechtw")
    private boolean geschlechtw;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isGeschlechtw() {
        return geschlechtw;
    }

    public void setGeschlechtw(boolean geschlechtw) {
        this.geschlechtw = geschlechtw;
    }
}

