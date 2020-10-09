package net.velion.arena.objective;

import net.velion.arena.IArenaEntity;

public class CaptureObjective extends Objective {

    public CaptureObjective(IArenaEntity entity) {
        super(entity);
    }

    @Override
    public boolean check() {
        return false;
    }

    @Override
    public Objective copy(IArenaEntity entity) {
        return new CaptureObjective(entity);
    }
}
