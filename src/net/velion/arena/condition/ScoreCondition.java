package net.velion.arena.condition;

import net.velion.arena.Arena;
import net.velion.arena.IArenaEntity;
import net.velion.arena.Status;

public class ScoreCondition extends Condition {
    private final int goal;

    public ScoreCondition(Arena arena, int goal) {
        super(arena);
        this.goal = goal;
    }

    public ScoreCondition(Arena arena, int goal, boolean evaluation) {
        super(arena, evaluation);
        this.goal = goal;
    }

    @Override
    public boolean check() {
        for (IArenaEntity entity : arena.getEntities()) {
            if (entity.getScore().getScore() >= goal || (arena.getCurrentRound().getStatus() == Status.OVER && isEvaluation())) {
                winner = entity;
                return true;
            }
        }
        return false;
    }
}
