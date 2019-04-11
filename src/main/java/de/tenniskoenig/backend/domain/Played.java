package de.tenniskoenig.backend.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "played")
public class Played implements Serializable {
//    @ManyToOne
    @Column(name = "GameID")
    private int gameID;
//    @ManyToOne
    @Column(name = "UserID")
    private int userID;
    @Column(name = "Points")
    private int points;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playedID")
    private int playedID;

    public Played()    { }

    public Played(int userID, int points, int playedID) {
        this.userID = userID;
        this.points = points;
        this.playedID = playedID;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPoints() {
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
