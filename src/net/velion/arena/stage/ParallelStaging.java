package net.velion.arena.stage;

import net.velion.arena.IArenaEntity;
import net.velion.arena.validation.ArenaInvalidException;

import java.util.Map;

public class ParallelStaging extends Staging {
    private Map<IArenaEntity, StageList> stageMapping;

    public void addStage(IArenaEntity entity, Stage stage) {
        if (stageMapping.containsKey(entity)) {
            stageMapping.get(entity).addStage(stage);
        } else {
            stageMapping.put(entity, new StageList(stage));
        }
    }

    @Override
    public void validate() throws ArenaInvalidException {
        super.validate();
        if (stageMapping == null || stageMapping.isEmpty()) {
            throw new ArenaInvalidException(9);
        } else {
            for (StageList stageList : stageMapping.values()) {
                stageList.validate();
            }
        }
    }

    @Override
    public void update(IArenaEntity entity) {
        IArenaEntity entity2 = stageMapping.get(entity).check();
        if (entity2 != null) {
            nextStage(entity2);
        }
    }

    public void nextStage(IArenaEntity entity) {
        stageMapping.get(entity).next();
    }
}
