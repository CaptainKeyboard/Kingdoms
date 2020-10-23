package net.velion.arena.builder.builders.conditionBuilder;

import net.velion.arena.Arena;
import net.velion.arena.condition.LastStageCondition;

public class LastStageConditionBuilder extends ConditionBuilder {
    @Override
    public LastStageCondition build(Arena arena) {
        return new LastStageCondition(arena);
    }

    @Override
    public ConditionBuilder setEvaluation(boolean evaluation) {
        return super.setEvaluation(evaluation);
    }

    @Override
    public ConditionBuilder setIgnore(boolean ignore) {
        return super.setIgnore(ignore);
    }
}
