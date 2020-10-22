package net.velion.arena.stage;

import net.velion.arena.IArenaEntity;
import net.velion.arena.validation.ArenaInvalidException;

import java.util.HashMap;
import java.util.Map;

public class ComplexStaging extends Staging {
    private final Map<IArenaEntity, StageList> stageMapping;
    private IArenaEntity currentStageEntity;

    public ComplexStaging() {
        stageMapping = new HashMap<>();
    }

    @Override
    public boolean hasNextStage(IArenaEntity entity) {
        if (currentStageEntity == null) {
            return stageMapping.containsKey(entity) && stageMapping.get(entity).size() >= 1;
        } else if (currentStageEntity.equals(entity)) {
            return stageMapping.get(entity).hasNext();
        } else {
            return true;
        }
    }

    @Override
    public void update(IArenaEntity entity) {
        IArenaEntity entity2;
        if (currentStageEntity != null) {
            entity2 = stageMapping.get(currentStageEntity).check();
        } else {
            entity2 = defaultStage.check();
        }
        if (entity2 != null) {
            nextStage(entity2);
        }
    }

    @Override
    public void validate() throws ArenaInvalidException {
        super.validate();
        if (stageMapping.isEmpty()) {
            throw new ArenaInvalidException(8);
        } else {
            for (StageList stageList : stageMapping.values()) {
                stageList.validate();
            }
        }
    }

    public void addStage(IArenaEntity entity, Stage stage) {
        if (stageMapping.containsKey(entity)) {
            stageMapping.get(entity).addStage(stage);
        } else {
            stageMapping.put(entity, new StageList(stage));
        }
    }

    public void nextStage(IArenaEntity entity) {
        if (currentStageEntity == null) {
            stageMapping.get(entity).next();
            currentStageEntity = entity;
        } else if (currentStageEntity.equals(entity)) {
            if (stageMapping.get(entity).hasNext()) {
                stageMapping.get(entity).next();
            }
        } else {
            if (stageMapping.get(currentStageEntity).hasPrevious()) {
                stageMapping.get(currentStageEntity).previous();
            } else {
                stageMapping.get(currentStageEntity).setCurrentStage(-1);
                currentStageEntity = null;
                defaultStage.start();
            }
        }
    }
}
