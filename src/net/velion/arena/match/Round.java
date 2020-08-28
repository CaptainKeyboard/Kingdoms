package net.velion.arena.match;

import java.util.ArrayList;
import java.util.List;

public class Round {
    boolean isOver;
    final List<Stage> stages;
    int currentStage;
    Match match;

    public Round() {
        this.stages = new ArrayList<>();
        currentStage = -1;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public void addStage(Stage stage) {
        stages.add(stage);
    }

    public void nextStage() {
        currentStage++;
        // TODO
    }

    public boolean hasNextStage() {
        return currentStage < stages.size() - 1;
    }

    public boolean isOver() {
        return isOver;
    }

    public void start() {
        // TODO
    }
}
