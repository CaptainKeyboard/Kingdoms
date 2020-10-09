package net.velion.arena.stage;

import net.velion.arena.Arena;
import net.velion.arena.IArenaEntity;
import net.velion.arena.objective.Objective;
import net.velion.arena.order.Order;

import java.util.ArrayList;
import java.util.List;

public class MonoStage extends Stage {
    private Arena arena;
    private List<Objective> objectives;

    public MonoStage(Arena arena) {
        super();
        this.arena = arena;
        objectives = new ArrayList<>();
    }

    @Override
    public void start() {
        for (IArenaEntity entity : arena.getEntities()) {
            Order order = new Order(entity);
            for (Objective objective : objectives) {
                order.addObjective(objective.copy(entity));
            }
            orders.add(order);
        }
        super.start();
    }

    @Deprecated
    @Override
    public void addOrder(Order order) {
        super.addOrder(order);
    }

    public void addObjective(Objective objective) {
        objectives.add(objective);
    }
}
