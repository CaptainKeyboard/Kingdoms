package net.velion.arena.builder.builders.orderBuilder;

import net.velion.arena.Arena;
import net.velion.arena.builder.builders.objectiveBuilder.ObjectiveBuilder;
import net.velion.arena.order.GlobalOrder;

import java.util.List;

public class GlobalOrderBuilder {
    private List<ObjectiveBuilder> objectiveBuilders;

    public GlobalOrderBuilder setObjectives(List<ObjectiveBuilder> objectives) {
        this.objectiveBuilders = objectives;
        return this;
    }

    public GlobalOrder build(Arena arena) {
        GlobalOrder globalOrder = new GlobalOrder();
        for (ObjectiveBuilder objectiveBuilder : objectiveBuilders) {
            globalOrder.addObjective(objectiveBuilder.build(arena));
        }
        return globalOrder;
    }
}
