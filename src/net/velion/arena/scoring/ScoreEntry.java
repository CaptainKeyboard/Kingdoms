package net.velion.arena.scoring;

import net.velion.Player;

public class ScoreEntry {
    final Player player;
    int kills;
    int captures;
    int teamkills;
    int points;

    public ScoreEntry(Player player) {
        this.player = player;
        this.kills = 0;
        this.captures = 0;
        this.teamkills = 0;
        this.points = 0;
    }

    public void updateEntry(int kills, int captures, int teamkills, int points) {
        this.kills += kills;
        this.captures += captures;
        this.teamkills += teamkills;
        this.points += points;
    }

    @Override
    public String toString() {
        return player.getName() + ":{" +
                "kills=" + kills +
                ", captures=" + captures +
                ", teamkills=" + teamkills +
                ", points=" + points +
                '}';
    }
}
