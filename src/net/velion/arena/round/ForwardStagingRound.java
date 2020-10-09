package net.velion.arena.round;

import net.velion.arena.stage.Stage;

public class ForwardStagingRound extends Round {
    private int currentStage;

    public ForwardStagingRound() {
        super();
        currentStage = -1;
    }

    @Override
    public Stage getCurrentStage() {
        return stages.get(currentStage);
    }

    @Override
    public void start() {
        nextStage().start();
    }

    public void reset() {
        currentStage = 0;
        for (Stage stage : stages) {
            stage.reset();
        }
    }

    public void check() {
    }

    private Stage nextStage() {
        currentStage++;
        return stages.get(currentStage);
    }
}
