package net.velion.arena.condition;

import net.velion.arena.Arena;
import net.velion.arena.IArenaEntity;

public class LastStageCondition extends Condition {
    public LastStageCondition(Arena arena) {
        super(arena);
    }

    @Override
    public boolean check() {
        for (IArenaEntity entity : arena.getEntities()) {
            if (!arena.getCurrentRound().getStaging().hasNextStage(entity)) {
                if (entity.checkObjectives()) {
                    winner = entity;
                    return true;
                }
            }
        }
        return false;
    }
}
