package com.example.isaac.gamedraw;

public class OneGameDraw {

    String teamA, teamB;

    public OneGameDraw(String teamA, String teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }
}
