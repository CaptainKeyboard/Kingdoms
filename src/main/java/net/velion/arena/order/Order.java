package net.velion.arena.order;

import net.velion.arena.IArenaEntity;
import net.velion.arena.objective.Objective;
import net.velion.arena.validation.ArenaInvalidException;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final IArenaEntity entity;
    protected List<Objective> objectives;

    public Order(IArenaEntity entity) {
        this.entity = entity;
        objectives = new ArrayList<>();
    }

    public IArenaEntity getEntity() {
        return entity;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public void addObjective(Objective objective) {
        objectives.add(objective);
    }

    public boolean check() {
        for (Objective objective : objectives) {
            if (objective.check()) {
                return false;
            }
        }
        return true;
    }

    public void reset() {
        entity.resetObjectives();
        entity.clearObjectives();
    }

    public void deliver() {
        entity.setObjectives(objectives);
    }

    public Order copy(IArenaEntity entity) {
        Order order = new Order(entity);
        for (Objective objective : objectives) {
            order.addObjective(objective.copy(entity));
        }
        return order;
    }

    public void append(Order order) {
        objectives.addAll(order.getObjectives());
    }

    public void validate() throws ArenaInvalidException {
        if (objectives == null || objectives.isEmpty()) {
            throw new ArenaInvalidException(6);
        } else {
            for (Objective objective : objectives) {
                objective.validate();
            }
        }
    }
}
