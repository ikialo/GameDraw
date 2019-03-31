package com.example.isaac.gamedraw;

public class FixtureInfo {

    String team1, time, location;


    public FixtureInfo(String team1, Object time, Object location) {
        this.team1 = team1;
        this.time = (String) time;
        this.location = (String) location;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
