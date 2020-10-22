package net.velion.arena.order;

import net.velion.arena.IArenaEntity;
import net.velion.arena.objective.Objective;
import net.velion.arena.validation.ArenaInvalidException;

import java.util.ArrayList;
import java.util.List;

public class GlobalOrder {
    protected final List<Objective> objectives;

    public GlobalOrder() {
        objectives = new ArrayList<>();
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public Order copy(IArenaEntity entity) {
        Order order = new Order(entity);
        for (Objective objective : objectives) {
            order.addObjective(objective.copy(entity));
        }
        return order;
    }

    public void addObjective(Objective objective) {
        objectives.add(objective);
    }

    public void validate() throws ArenaInvalidException {
        if (objectives.isEmpty()) {
            throw new ArenaInvalidException(7);
        } else {
            for (Objective objective : objectives) {
                objective.validate();
            }
        }
    }
}
