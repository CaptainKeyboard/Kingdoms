package net.velion.arena.builder.builders.roundBuilder;

import net.velion.arena.Arena;
import net.velion.arena.builder.builders.conditionBuilder.ConditionBuilder;
import net.velion.arena.builder.builders.stagingBuilder.StagingBuilder;
import net.velion.arena.round.Round;

import java.util.List;

public class RoundBuilder {
    private StagingBuilder stagingBuilder;
    private List<ConditionBuilder> conditionBuilders;

    public RoundBuilder setStaging(StagingBuilder staging) {
        this.stagingBuilder = staging;
        return this;
    }

    public RoundBuilder setConditions(List<ConditionBuilder> conditionBuilders) {
        this.conditionBuilders = conditionBuilders;
        return this;
    }

    public Round build(Arena arena) {
        Round round = new Round(arena);
        round.setStaging(stagingBuilder.build(arena));
        for (ConditionBuilder conditionBuilder : conditionBuilders) {
            round.addCondition(conditionBuilder.build(arena));
        }
        return round;
    }
}
