package net.velion.arena.objective;

import net.velion.arena.IArenaEntity;

/**
 * @author Franz Kohout
 */
public class KillObjective extends Objective {
    private int goal;

    public KillObjective(IArenaEntity entity, int goal) {
        super(entity);
        this.goal = goal;
    }

    public KillObjective(int orderID, IArenaEntity entity, int goal) {
        super(orderID, entity);
        this.goal = goal;
    }

    @Override
    public boolean check() {
        return entity.getScore().getKills() == goal;
    }

    @Override
    public Objective copy(IArenaEntity entity) {
        return new KillObjective(orderID, entity, goal);
    }
}
