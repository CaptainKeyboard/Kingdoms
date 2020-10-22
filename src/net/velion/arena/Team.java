package net.velion.arena;

import net.velion.arena.objective.Objective;
import net.velion.arena.score.ScoreTable;

import java.util.ArrayList;
import java.util.List;

public class Team implements IArenaEntity {
    private final String name;
    private final ScoreTable scoreTable;
    private final List<Player> members;
    private List<Objective> objectives;

    public Team(String name) {
        this.name = name;
        members = new ArrayList<>();
        scoreTable = new ScoreTable();
    }

    public void addMember(Player player) {
        members.add(player);
        player.setTeam(this);
        scoreTable.addEntry(player.getScore());
    }

    public void addAllMembers(List<Player> players) {
        members.addAll(players);
        players.forEach(player -> player.setTeam(this));
    }

    @Override
    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
        for (Player player : members) {
            player.setObjectives(objectives);
        }
    }

    @Override
    public void addObjective(Objective objective) {
        objectives.add(objective);
        for (Player player : members) {
            player.addObjective(objective);
        }
    }

    @Override
    public void addAllObjectives(List<Objective> objectives) {
        this.objectives.addAll(objectives);
        for (Player player : members) {
            player.addAllObjectives(objectives);
        }
    }

    @Override
    public void clearObjectives() {
        objectives = null;
        for (Player player : members) {
            player.clearObjectives();
        }
    }

    @Override
    public ScoreTable getScore() {
        return scoreTable;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean checkObjectives() {
        for (Objective objective : objectives) {
            if (objective.check()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void resetObjectives() {
        for (Objective objective : objectives) {
            objective.reset();
        }
    }

    public int size() {
        return members.size();
    }

    public List<Player> getMembers() {
        return members;
    }
}
