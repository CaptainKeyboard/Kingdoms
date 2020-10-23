package net.velion.arena.score;

import net.velion.arena.Player;

public class ScoreEntry implements IScoreType {
    private final Player player;
    private int score;
    private int kills;

    public ScoreEntry(Player player) {
        this.player = player;
        score = 0;
        kills = 0;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int getKills() {
        return kills;
    }

    @Override
    public void reset() {
        score = 0;
        kills = 0;
    }

    public void addKill(int i) {
        score += 100;
        kills++;
    }

    public Player getPlayer() {
        return player;
    }
}
