package net.velion.arena.builder.builders.orderBuilder;

import net.velion.arena.Arena;
import net.velion.arena.IArenaEntity;
import net.velion.arena.builder.builders.objectiveBuilder.ObjectiveBuilder;
import net.velion.arena.order.Order;

import java.util.List;
import java.util.Optional;

public class OrderBuilder {
    private String entity;
    private List<ObjectiveBuilder> objectiveBuilders;

    public OrderBuilder(String entity) {
        this.entity = entity;
    }

    public OrderBuilder setObjectives(List<ObjectiveBuilder> objectives) {
        this.objectiveBuilders = objectives;
        return this;
    }

    public Order build(Arena arena) {
        Optional<IArenaEntity> entity1 = (Optional<IArenaEntity>) arena.getEntities().stream().filter(entity2 -> entity2.getName().equals(entity)).findFirst();
        Order order = new Order(entity1.get());
        for (ObjectiveBuilder objectiveBuilder : objectiveBuilders) {
            order.addObjective(objectiveBuilder.build(arena));
        }
        return order;
    }
}
