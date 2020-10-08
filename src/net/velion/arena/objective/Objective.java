package net.velion.arena.objective;

import net.velion.arena.IArenaEntity;

/**
 * @author Franz Kohout
 */
public abstract class Objective {
    protected int orderID;
    protected IArenaEntity entity;

    public Objective(IArenaEntity entity) {
        orderID = 0;
        this.entity = entity;
    }

    public Objective(int orderID, IArenaEntity entity) {
        this.orderID = orderID;
        this.entity = entity;
    }

    public abstract boolean check();

    public int getOrderID() {
        return orderID;
    }

    public abstract Objective copy(IArenaEntity entity);
}
