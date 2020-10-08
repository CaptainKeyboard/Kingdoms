package net.velion.arena.stage;

import net.velion.arena.objective.Objective;
import net.velion.arena.order.Order;

import java.util.List;

/**
 * @author Franz Kohout
 */
public class MonoStage extends Stage{
    public MonoStage() {
        orders.add(new Order(null));
    }



    public void setObjectives(List<Objective> objectives) {
        orders.get(0).setObjectives(objectives);
    }

    public void addObjective(Objective objective) {
        orders.get(0).addObjective(objective);
    }
}
