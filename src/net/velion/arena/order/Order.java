package net.velion.arena.order;

import net.velion.arena.IArenaEntity;
import net.velion.arena.objective.Objective;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Franz Kohout
 */
public class Order {
    private IArenaEntity entity;
    private List<Objective> objectives;
    private int currentOrderID;

    public Order(IArenaEntity entity) {
        this.entity = entity;
    }

    public void reset() {
        currentOrderID = 0;
        entity.clearObjectives();
    }

    public boolean check() {
        boolean achieved = true;
        for(Objective objective: objectives) {
            if(!objective.check()) {
                achieved = false;
            }
        }

        if(achieved) {
            return true;
        }

        List<Objective> currentObjective = objectives.stream().filter(objective -> { return objective.getOrderID() == currentOrderID; }).collect(Collectors.toList());

    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public void addObjective(Objective objective) {
        objectives.add(objective);
    }
}
