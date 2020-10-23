package net.velion.arena.capturing;

import net.velion.arena.IArenaEntity;

public class CapturePoint {
    private final String name;
    private IArenaEntity entity;

    public CapturePoint(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public IArenaEntity getEntity() {
        return entity;
    }

    public void capture(IArenaEntity entity) {
        this.entity = entity;
    }

    public void reset() {
        entity = null;
    }
}
