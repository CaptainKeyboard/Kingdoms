package net.velion.arena.score;

public class ScoreEntry implements IScoreType {
    private int score;
    private int kills;

    public ScoreEntry() {
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
}
