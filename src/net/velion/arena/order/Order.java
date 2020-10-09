package net.velion.arena.order;

import net.velion.arena.IArenaEntity;
import net.velion.arena.objective.Objective;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private IArenaEntity entity;
    private List<Objective> objectives;
    private int currentOrderID;

    public Order(IArenaEntity entity) {
        this.entity = entity;
        objectives = new ArrayList<>();
    }

    public void reset() {
        currentOrderID = 0;
        entity.clearObjectives();
    }

    public boolean check() {
        for (Objective objective : objectives) {
            if (!objective.check()) {
                return false;
            }
        }
        return true;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public void addObjective(Objective objective) {
        objectives.add(objective);
    }

    public IArenaEntity getEntity() {
        return entity;
    }

    public void deliver() {
        entity.setObjectives(objectives);
    }
}
