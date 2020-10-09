package net.velion.arena.round;

import net.velion.arena.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public abstract class Round {
    protected List<Stage> stages;

    public Round() {
        stages = new ArrayList<>();
    }

    public abstract Stage getCurrentStage();

    public void addStage(Stage stage) {
        stages.add(stage);
    }

    public abstract void start();

    public abstract void reset();
}
