package net.velion.arena;

import net.velion.arena.objective.Objective;
import net.velion.arena.score.IScoreType;
import net.velion.arena.score.ScoreTable;

import java.util.ArrayList;
import java.util.List;

public class Team implements IArenaEntity {
    private List<Player> members;
    private ScoreTable scoreTable;

    public Team() {
        members = new ArrayList<>();
    }

    public void setMemebers(List<Player> players) {
        members = players;
    }

    public void addMember(Player player) {
        members.add(player);
    }

    public void addAllMembers(List<Player> players) {
        members.addAll(players);
    }

    @Override
    public void setObjectives(List<Objective> objectives) {
        for (Player player : members) {
            player.setObjectives(objectives);
        }
    }

    @Override
    public void addObjective(Objective objective) {
        for (Player player : members) {
            player.addObjective(objective);
        }
    }

    @Override
    public void clearObjectives() {
        for (Player player : members) {
            player.clearObjectives();
        }
    }

    @Override
    public IScoreType getScore() {
        return scoreTable;
    }

    public int size() {
        return members.size();
    }
}
