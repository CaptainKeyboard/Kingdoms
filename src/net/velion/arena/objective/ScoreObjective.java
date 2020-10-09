package net.velion.arena.objective;

import net.velion.arena.IArenaEntity;

public class ScoreObjective extends Objective {
    private int goal;

    public ScoreObjective(IArenaEntity entity, int goal) {
        super(entity);
        this.goal = goal;
    }

    public ScoreObjective(int orderID, IArenaEntity entity, int goal) {
        super(orderID, entity);
        this.goal = goal;
    }

    @Override
    public boolean check() {
        return entity.getScore().getScore() == goal;
    }

    @Override
    public Objective copy(IArenaEntity entity) {
        return new ScoreObjective(orderID, entity, goal);
    }
}