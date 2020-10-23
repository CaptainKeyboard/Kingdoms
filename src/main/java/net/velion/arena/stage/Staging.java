package net.velion.arena.stage;

import net.velion.arena.IArenaEntity;
import net.velion.arena.validation.ArenaInvalidException;

public class Staging {
    protected Stage defaultStage;

    public void setDefaultStage(Stage defaultStage) {
        this.defaultStage = defaultStage;
    }

    public void start() {
        defaultStage.start();
    }

    public boolean hasNextStage(IArenaEntity entity) {
        return false;
    }

    public void update(IArenaEntity entity) {
    }

    public void validate() throws ArenaInvalidException {
        if (defaultStage == null) {
            throw new ArenaInvalidException(3);
        } else {
            defaultStage.validate();
        }
    }
}
