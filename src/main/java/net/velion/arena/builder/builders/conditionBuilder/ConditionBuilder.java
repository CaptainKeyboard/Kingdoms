package net.velion.arena.builder.builders.conditionBuilder;

import net.velion.arena.Arena;
import net.velion.arena.condition.Condition;

public abstract class ConditionBuilder {
    protected boolean evaluation;
    protected boolean ignore;

    public ConditionBuilder() {
        evaluation = false;
        ignore = false;
    }

    public abstract Condition build(Arena arena);

    public ConditionBuilder setEvaluation(boolean evaluation) {
        this.evaluation = evaluation;
        return this;
    }

    public ConditionBuilder setIgnore(boolean ignore) {
        this.ignore = ignore;
        return this;
    }
}
