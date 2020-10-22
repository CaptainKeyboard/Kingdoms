package net.velion.arena.objective;

import net.velion.arena.IArenaEntity;
import net.velion.arena.capturing.CapturePoint;
import net.velion.arena.validation.ArenaInvalidException;

public class CaptureObjective extends Objective {
    private final CapturePoint capturePoint;

    public CaptureObjective(CapturePoint capturePoint, IArenaEntity entity) {
        super(entity);
        this.capturePoint = capturePoint;
    }

    @Override
    public boolean check() {
        return capturePoint.getEntity() == entity;
    }

    @Override
    public Objective copy(IArenaEntity entity) {
        return new CaptureObjective(capturePoint, entity);
    }

    @Override
    public void reset() {
        capturePoint.reset();
    }

    @Override
    public void validate() throws ArenaInvalidException {
        if (capturePoint == null) {
            throw new ArenaInvalidException(101);
        }
    }
}
