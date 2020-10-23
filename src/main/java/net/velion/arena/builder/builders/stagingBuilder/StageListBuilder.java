package net.velion.arena.builder.builders.stagingBuilder;

import net.velion.arena.Arena;
import net.velion.arena.stage.StageList;

import java.util.List;

public class StageListBuilder {
    private String entity;
    private List<StageBuilder> stageBuilders;

    public StageListBuilder(String entity) {
        this.entity = entity;
    }

    public StageListBuilder setStages(List<StageBuilder> stages) {
        this.stageBuilders = stages;
        return this;
    }

    public String getEntity() {
        return entity;
    }

    public StageList build(Arena arena) {
        StageList stageList = new StageList();
        for (StageBuilder stageBuilder : stageBuilders) {
            stageList.addStage(stageBuilder.build(arena));
        }
        return stageList;
    }
}
