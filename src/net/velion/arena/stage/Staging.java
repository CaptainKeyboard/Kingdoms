package net.velion.arena.stage;

import net.velion.arena.IArenaEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Staging {
    private Stage defaultStage;
    private Map<IArenaEntity, List<Stage>> stageMapping;
    private IArenaEntity currentStageEntity;
    private int currentStageID;

    public Staging() {
        stageMapping = new HashMap<>();
        currentStageEntity = null;
        currentStageID = 0;
    }

    public void setDefaultStage(Stage defaultStage) {
        this.defaultStage = defaultStage;
    }

    public void addStage(IArenaEntity entity, Stage stage) {
        if (stageMapping.containsKey(entity)) {
            stageMapping.get(entity).add(stage);
        } else {
            stageMapping.put(entity, Arrays.asList(stage));
        }
    }

    public void start() {
        defaultStage.start();
    }

    public Stage nextStage(IArenaEntity entity) {
        if (currentStageEntity == null || currentStageEntity == entity) {
            currentStageEntity = entity;
            currentStageID++;
        } else if (currentStageEntity != entity) {
            currentStageID--;
        }
        if (currentStageID == 0) {
            currentStageEntity = null;
            return defaultStage;
        } else {
            return stageMapping.get(entity).get(currentStageID - 1);
        }
    }
}
