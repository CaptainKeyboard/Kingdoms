package net.velion.arena.scoring;

import net.velion.Player;
import net.velion.arena.team.Team;

import java.util.List;
import java.util.Optional;

public class Scoreboard {
    List<TeamScoreboard> scoreboards;

    public void updateScore(Team team, Player player, int kills, int captures, int teamkills, int points) {
        Optional<TeamScoreboard> scoreboard = scoreboards.stream().filter(scoreboard2 -> {
            return scoreboard2.team == team;
        }).findFirst();
        scoreboard.ifPresent(teamScoreboard -> teamScoreboard.updateScore(player, kills, captures, teamkills, points));
    }
}
