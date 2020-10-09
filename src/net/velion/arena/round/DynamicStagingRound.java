package net.velion.arena.round;

import net.velion.arena.IArenaEntity;
import net.velion.arena.stage.Stage;
import net.velion.arena.stage.Staging;

public class DynamicStagingRound extends Round {
    private Staging staging;

    public DynamicStagingRound() {
        staging = new Staging();
    }

    public void setDefaultStage(Stage stage) {
        staging.setDefaultStage(stage);
    }

    @Override
    public Stage getCurrentStage() {
        return null;
    }

    @Override
    public void start() {
        staging.start();
    }

    @Override
    public void reset() {

    }

    @Deprecated
    @Override
    public void addStage(Stage stage) {
    }

    public void addStage(IArenaEntity entity, Stage stage) {
        staging.addStage(entity, stage);
    }
}
