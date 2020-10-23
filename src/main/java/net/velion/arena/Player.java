package net.velion.arena;

import net.velion.arena.objective.Objective;
import net.velion.arena.score.ScoreEntry;

import java.util.ArrayList;
import java.util.List;

public class Player implements IArenaEntity {
    private final ScoreEntry scoreEntry;
    private final String name;
    private Party party;
    private Team team;
    private List<Objective> objectives;

    public Player(String name) {
        this.name = name;
        objectives = new ArrayList<>();
        scoreEntry = new ScoreEntry(this);
    }

    @Override
    public void addObjective(Objective objective) {
        objectives.add(objective);
    }

    @Override
    public void addAllObjectives(List<Objective> objectives) {
        objectives.addAll(objectives);
    }

    @Override
    public void clearObjectives() {
        objectives = new ArrayList<>();
    }

    @Override
    public ScoreEntry getScore() {
        return scoreEntry;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean checkObjectives() {
        for (Objective objective : objectives) {
            if (objective.check()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void resetObjectives() {
        for (Objective objective : objectives) {
            objective.reset();
        }
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    @Override
    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
