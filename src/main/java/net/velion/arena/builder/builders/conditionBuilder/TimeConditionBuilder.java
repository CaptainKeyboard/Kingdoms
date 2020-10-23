package net.velion.arena.builder.builders.conditionBuilder;

import net.velion.arena.Arena;
import net.velion.arena.condition.Condition;
import net.velion.arena.condition.TimeCondition;

public class TimeConditionBuilder extends ConditionBuilder {
    private int time;

    public TimeConditionBuilder(int time) {
        this.time = time;
    }

    @Override
    public Condition build(Arena arena) {
        return new TimeCondition(arena, time);
    }

    @Override
    public TimeConditionBuilder setEvaluation(boolean evaluation) {
        return (TimeConditionBuilder) super.setEvaluation(evaluation);
    }

    @Override
    public TimeConditionBuilder setIgnore(boolean ignore) {
        return (TimeConditionBuilder) super.setIgnore(ignore);
    }
}
