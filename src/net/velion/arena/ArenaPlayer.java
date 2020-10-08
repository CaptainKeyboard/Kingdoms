package net.velion.arena;

import net.velion.arena.objective.Objective;
import net.velion.arena.score.IScoreType;
import net.velion.arena.score.ScoreEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Franz Kohout
 */
public class ArenaPlayer implements IArenaEntity {
    private String name;
    private Party party;
    private Team team;
    private List<Objective> objectives;
    private ScoreEntry scoreEntry;

    public ArenaPlayer(String name) {
        this.name = name;
        objectives = new ArrayList<>();
        scoreEntry = new ScoreEntry();
    }

    @Override
    public void setObjectives(List<Objective> objectives) {
        objectives = objectives;
    }

    @Override
    public void addObjective(Objective objective) {
        objectives.add(objective);
    }

    @Override
    public void clearObjectives() {
        objectives = new ArrayList<>();
    }

    @Override
    public IScoreType getScore() {
        return scoreEntry;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }
}
