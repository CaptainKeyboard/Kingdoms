package net.velion.arena;

import net.velion.arena.objective.Objective;
import net.velion.arena.score.IScoreType;

import java.util.List;

/**
 * @author Franz Kohout
 */
public interface IArenaEntity {
    void setObjectives(List<Objective> objectives);
    void addObjective(Objective objective);
    void clearObjectives();
    IScoreType getScore();
}
