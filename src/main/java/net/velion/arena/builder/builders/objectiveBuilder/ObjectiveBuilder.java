package net.velion.arena.builder.builders.objectiveBuilder;

import net.velion.arena.Arena;
import net.velion.arena.objective.Objective;

public abstract class ObjectiveBuilder {
    protected String entity;

    public ObjectiveBuilder(String entity) {
        this.entity = entity;
    }

    public abstract Objective build(Arena arena);
}
