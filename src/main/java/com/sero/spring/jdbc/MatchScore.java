package com.sero.spring.jdbc;

import javax.persistence.*;

@Entity
@Table(name = "matchscore")
public class Matchscore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "hometeam")
    private int homeTeam;

    @Column(name = "homescore")
    private int homeScore;

    @Column(name = "awayteam")
    private int awayTeam;

    @Column(name = "awayscore")
    private int awayScore;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHomeTeam() {
        return this.homeTeam;
    }

    public void setHomeTeam(int homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getHomeScore() {
        return this.homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayTeam() {
        return this.awayTeam;
    }

    public void setAwayTeam(int awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getAwayScore() {
        return this.awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }
}
