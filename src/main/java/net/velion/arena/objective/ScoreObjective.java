package net.velion.arena.objective;

import net.velion.arena.IArenaEntity;
import net.velion.arena.validation.ArenaInvalidException;

public class ScoreObjective extends Objective {
    private final int goal;

    public ScoreObjective(IArenaEntity entity, int goal) {
        super(entity);
        this.goal = goal;
    }

    @Override
    public boolean check() {
        return entity.getScore().getScore() == goal;
    }

    @Override
    public Objective copy(IArenaEntity entity) {
        return new ScoreObjective(entity, goal);
    }

    @Override
    public void reset() {
        entity.getScore().reset();
    }

    @Override
    public void validate() throws ArenaInvalidException {
        if (goal <= 0) {
            throw new ArenaInvalidException(103);
        }
    }
}