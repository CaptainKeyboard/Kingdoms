package net.velion.arena.round;

import net.velion.arena.stage.Stage;

public class SingleStageRound extends Round {
    @Override
    public void addStage(Stage stage) {
        stages.add(0, stage);
    }

    @Override
    public Stage getCurrentStage() {
        return stages.get(0);
    }

    @Override
    public void start() {
        stages.get(0).start();
    }

    @Override
    public void reset() {

    }
}
