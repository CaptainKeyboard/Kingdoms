package net.velion.arena.round;

import net.velion.arena.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Franz Kohout
 */
public class Round {
    private List<Stage> stages;
    private int currentStage;

    public Round() {
        stages = new ArrayList<>();
        currentStage = 0;
    }

    public void start() {
        stages.get(currentStage).start();
    }

    public void reset() {
        currentStage = 0;
        for(Stage stage: stages) {
            stage.reset();
        }
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    public void addStage(Stage stage) {
        stages.add(stage);
    }
}
