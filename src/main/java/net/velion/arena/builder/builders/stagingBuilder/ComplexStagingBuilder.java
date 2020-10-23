package net.velion.arena.builder.builders.stagingBuilder;

import net.velion.arena.Arena;
import net.velion.arena.IArenaEntity;
import net.velion.arena.stage.ComplexStaging;
import net.velion.arena.stage.Staging;

import java.util.List;
import java.util.Optional;

public class ComplexStagingBuilder extends StagingBuilder {
    private List<StageListBuilder> stageListBuilders;

    @Override
    public Staging build(Arena arena) {
        ComplexStaging complexStaging = new ComplexStaging();
        complexStaging.setDefaultStage(defaultStageBuilder.build(arena));
        for (StageListBuilder stageListBuilder : stageListBuilders) {
            Optional<IArenaEntity> entity = (Optional<IArenaEntity>) arena.getEntities().stream().filter(entity1 -> entity1.getName().equals(stageListBuilder.getEntity())).findFirst();
            complexStaging.setStageList(entity.get(), stageListBuilder.build(arena));
        }
        return complexStaging;
    }

    @Override
    public ComplexStagingBuilder setDefaultStage(StageBuilder defaultStageBuilder) {
        return (ComplexStagingBuilder) super.setDefaultStage(defaultStageBuilder);
    }

    public ComplexStagingBuilder setStageMapping(List<StageListBuilder> stageLists) {
        this.stageListBuilders = stageLists;
        return this;
    }
}
