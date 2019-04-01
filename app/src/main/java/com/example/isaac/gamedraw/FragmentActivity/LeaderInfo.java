package com.example.isaac.gamedraw.FragmentActivity;

public class LeaderInfo {

    String team, play,won,lost, points;

    public LeaderInfo(Object team, Object play, Object won, Object lost, Object points) {
        this.team = (String) team;
        this.play = (String) play;
        this.won = (String) won;
        this.lost = (String) lost;
        this.points = (String) points;
    }


    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public String getWon() {
        return won;
    }

    public void setWon(String won) {
        this.won = won;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
