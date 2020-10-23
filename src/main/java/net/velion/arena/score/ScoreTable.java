package net.velion.arena.score;

import net.velion.arena.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScoreTable implements IScoreType {
    private final List<ScoreEntry> entries;

    public ScoreTable() {
        entries = new ArrayList<>();
    }

    @Override
    public int getScore() {
        return entries.stream().mapToInt(ScoreEntry::getScore).sum();
    }

    @Override
    public int getKills() {
        return entries.stream().mapToInt(ScoreEntry::getKills).sum();
    }

    @Override
    public void reset() {
        for (ScoreEntry entry : entries) {
            entry.reset();
        }
    }

    public List<ScoreEntry> getEntries() {
        return entries;
    }

    public ScoreEntry getEntry(Player player) {
        Optional<ScoreEntry> entry = entries.stream().filter(scoreEntry -> scoreEntry.getPlayer().equals(player)).findFirst();
        return entry.orElse(null);
    }

    public void addEntry(ScoreEntry scoreEntry) {
        entries.add(scoreEntry);
    }
}
