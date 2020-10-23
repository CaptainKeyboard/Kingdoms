package net.velion.arena.objective;

import net.velion.arena.IArenaEntity;
import net.velion.arena.validation.ArenaInvalidException;

public abstract class Objective {
    protected final IArenaEntity entity;

    public Objective(IArenaEntity entity) {
        this.entity = entity;
    }

    public abstract boolean check();

    public abstract Objective copy(IArenaEntity entity);

    public abstract void reset();

    public abstract void validate() throws ArenaInvalidException;
}
