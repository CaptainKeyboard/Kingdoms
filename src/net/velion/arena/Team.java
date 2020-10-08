package net.velion.arena;

import net.velion.arena.objective.Objective;
import net.velion.arena.score.IScoreType;
import net.velion.arena.score.ScoreTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Franz Kohout
 */
public class Team implements IArenaEntity {
    private List<ArenaPlayer> members;
    private ScoreTable scoreTable;

    public Team() {
        members = new ArrayList<>();
    }

    public void setMemebers(List<ArenaPlayer> players) {
        members = players;
    }

    public void addMember(ArenaPlayer player) {
        members.add(player);
    }

    public void addAllMembers(List<ArenaPlayer> players) {
        members.addAll(players);
    }

    @Override
    public void setObjectives(List<Objective> objectives) {
        for(ArenaPlayer player: members) {
            player.setObjectives(objectives);
        }
    }

    @Override
    public void addObjective(Objective objective) {
        for(ArenaPlayer player: members) {
            player.addObjective(objective);
        }
    }

    @Override
    public void clearObjectives() {
        for(ArenaPlayer player: members) {
            player.clearObjectives();
        }
    }

    @Override
    public IScoreType getScore() {
        return scoreTable;
    }

    public int getCount() {
        return members.size();
    }
}
