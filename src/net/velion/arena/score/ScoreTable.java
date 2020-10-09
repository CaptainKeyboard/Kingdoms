package net.velion.arena.score;

import java.util.List;

public class ScoreTable implements IScoreType {
    private List<ScoreEntry> entries;

    @Override
    public int getScore() {
        return entries.stream().mapToInt(ScoreEntry::getScore).sum();
    }

    @Override
    public int getKills() {
        return entries.stream().mapToInt(ScoreEntry::getKills).sum();
    }
}
