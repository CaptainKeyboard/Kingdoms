package net.velion.arena.builder.builders.conditionBuilder;

import net.velion.arena.Arena;
import net.velion.arena.condition.ScoreCondition;

public class ScoreConditionBuilder extends ConditionBuilder {
    private int goal;

    public ScoreConditionBuilder(int goal) {
        this.goal = goal;
    }

    @Override
    public ScoreCondition build(Arena arena) {
        return new ScoreCondition(arena, goal, evaluation);
    }

    @Override
    public ScoreConditionBuilder setEvaluation(boolean evaluation) {
        return (ScoreConditionBuilder) super.setEvaluation(evaluation);
    }

    @Override
    public ScoreConditionBuilder setIgnore(boolean ignore) {
        return (ScoreConditionBuilder) super.setIgnore(ignore);
    }
}
