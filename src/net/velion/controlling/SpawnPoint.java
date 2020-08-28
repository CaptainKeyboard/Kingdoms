package net.velion.controlling;

import net.velion.arena.Arena;
import net.velion.arena.team.Team;

import java.util.List;

public class SpawnPoint extends ControlPoint{
    List<Team> teams = null;
    boolean ignoreTeams = false;

    public SpawnPoint(Arena arena, Location location, String name, List<Team> teams) {
        super(arena, location, name);
        if(teams != null) {
            this.teams = teams;
        }
        else {
            ignoreTeams = true;
        }
    }

    public boolean containsTeam(Team team) {
        return teams.contains(team);
    }

    public boolean ignoringTeams() {
        return ignoreTeams;
    }
}
