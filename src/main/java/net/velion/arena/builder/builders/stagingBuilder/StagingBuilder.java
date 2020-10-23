package net.velion.arena.builder.builders.stagingBuilder;

import net.velion.arena.Arena;
import net.velion.arena.stage.Staging;

public abstract class StagingBuilder {
    protected StageBuilder defaultStageBuilder;

    public StagingBuilder setDefaultStage(StageBuilder defaultStageBuilder) {
        this.defaultStageBuilder = defaultStageBuilder;
        return this;
    }

    public abstract Staging build(Arena arena);
}
