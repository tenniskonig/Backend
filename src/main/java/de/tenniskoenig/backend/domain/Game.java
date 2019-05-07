package de.tenniskoenig.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "game")
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long gameID;
    @Column(name = "player1Team1")
    private long player1Team1;
    @Column(name = "player2Team2")
    private long player2Team2;
    @Column(name = "player3Team1")
    private long player3Team1;
    @Column(name = "player4Team2")
    private long player4Team2;
    @Column(name = "results")
    private String results;
    @Column(name = "gameSetTeam1")
    private long gameSetTeam1;
    @Column(name = "gameSetTeam2")
    private long gameSetTeam2;
    @Column(name = "gameDate")
    private Date gameDate;
    @Column(name = "playTime")
    private Time playTime;

    public Game() {
    }

    public Game(int player1Team1, int player2Team2, int player3Team1, int player4Team2, String results, int gameSetTeam1, int gameSetTeam2, Date gameDate, Time playTime) {
        this.player1Team1 = player1Team1;
        this.player2Team2 = player2Team2;
        this.player3Team1 = player3Team1;
        this.player4Team2 = player4Team2;
        this.results = results;
        this.gameSetTeam1 = gameSetTeam1;
        this.gameSetTeam2 = gameSetTeam2;
        this.gameDate = gameDate;
        this.playTime = playTime;
    }

    public Game(int player1Team1, int player2Team2, String results, int gameSetTeam1, int gameSetTeam2, Date gameDate, Time playTime) {
        this.player1Team1 = player1Team1;
        this.player2Team2 = player2Team2;
        this.results = results;
        this.gameSetTeam1 = gameSetTeam1;
        this.gameSetTeam2 = gameSetTeam2;
        this.gameDate = gameDate;
        this.playTime = playTime;
    }

    public long getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public long getPlayer1Team1() {
        return player1Team1;
    }

    public void setPlayer1Team1(int player1Team1) {
        this.player1Team1 = player1Team1;
    }

    public long getPlayer2Team2() {
        return player2Team2;
    }

    public void setPlayer2Team2(int player2Team2) {
        this.player2Team2 = player2Team2;
    }

    public long getPlayer3Team1() {
        return player3Team1;
    }

    public void setPlayer3Team1(int player3Team1) {
        this.player3Team1 = player3Team1;
    }

    public long getPlayer4Team2() {
        return player4Team2;
    }

    public void setPlayer4Team2(int player4Team2) {
        this.player4Team2 = player4Team2;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public long getGameSetTeam1() {
        return gameSetTeam1;
    }

    public void setGameSetTeam1(int gameSetTeam1) {
        this.gameSetTeam1 = gameSetTeam1;
    }

    public long getGameSetTeam2() {
        return gameSetTeam2;
    }

    public void setGameSetTeam2(int gameSetTeam2) {
        this.gameSetTeam2 = gameSetTeam2;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public Time getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Time playTime) {
        this.playTime = playTime;
    }
}
