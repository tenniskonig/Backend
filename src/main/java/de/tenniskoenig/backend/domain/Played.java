package de.tenniskoenig.backend.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "played")
public class Played implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playedID")
    private int playedID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GameID")
    private Game gameID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User userID;
    @Column(name = "Points")
    private int points;

    public Played() {
    }

    public Played(User userID, int points, Game gameID) {
        this.userID = userID;
        this.points = points;
        this.gameID = gameID;
    }

    public Game getGameID() {
        return gameID;
    }

    public void setGameID(Game gameID) {
        this.gameID = gameID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPlayedID() {
        return playedID;
    }

    public void setPlayedID(int playerID) {
        this.playedID = playerID;
    }
}
