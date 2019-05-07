package de.tenniskoenig.backend.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "played")
public class Played implements Serializable {
    //    @ManyToOne
    @Column(name = "GameID")
    private long gameID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User userID;
    @Column(name = "Points")
    private int points;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playedID")
    private long playedID;

    public Played() {
    }

    public Played(User userID, int points, int playedID) {
        this.userID = userID;
        this.points = points;
        this.playedID = playedID;
    }

    public long getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
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

    public long getPlayedID() {
        return playedID;
    }

    public void setPlayedID(int playerID) {
        this.playedID = playerID;
    }
}
