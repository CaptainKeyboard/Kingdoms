package net.velion.arena.scoring;

import net.velion.Player;
import net.velion.arena.team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamScoreboard {
    final Team team;
    final List<ScoreEntry> entries;

    int pointsForKill = 10;
    final int pointsForCapture = 50;
    int pointsForTeamkill = -20;

    public TeamScoreboard(Team team) {
        this.team = team;
        entries = new ArrayList<>();
        for (Player player : team.getMembers()) {
            entries.add(new ScoreEntry(player));
        }
    }

    public void addEntry(Player player) {
        entries.add(new ScoreEntry(player));
    }

    public void updateScore(Player player, int kills, int captures, int teamkills, int points) {
        Optional<ScoreEntry> entry = entries.stream().filter(entry2 -> {
            return entry2.player == player;
        }).findFirst();
        entry.ifPresent(scoreEntry -> scoreEntry.updateEntry(kills, captures, teamkills, points));
    }

    public int getTeamScore() {
        int teamScore = 0;
        for (ScoreEntry scoreEntry : entries) {
            teamScore += scoreEntry.points;
        }
        return teamScore;
    }

    public void addCapture(Player player) {
        updateScore(player, 0, 1, 0, pointsForCapture);
    }

    @Override
    public String toString() {
        return team.getName() + ":{ Score: " + getTeamScore() + ' ' + entries + '}';
    }
}
