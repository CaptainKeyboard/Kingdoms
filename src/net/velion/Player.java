package net.velion;

import net.velion.arena.team.Team;

public class Player {
    final String name;
    Team team;

    public Player(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }
}
