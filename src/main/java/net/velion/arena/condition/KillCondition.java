package net.velion.arena.condition;

import net.velion.arena.Arena;
import net.velion.arena.IArenaEntity;
import net.velion.arena.Status;

public class KillCondition extends Condition {
    private final int goal;

    public KillCondition(Arena arena, int goal) {
        super(arena);
        this.goal = goal;
    }

    public KillCondition(Arena arena, int goal, boolean evaluation) {
        super(arena, evaluation);
        this.goal = goal;
    }

    @Override
    public boolean check() {
        for (IArenaEntity entity : arena.getEntities()) {
            if (entity.getScore().getKills() >= goal || (arena.getStatus() == Status.OVER && isEvaluation())) {
                winner = entity;
                return true;
            }
        }
        return false;
    }
}
