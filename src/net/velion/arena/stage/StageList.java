package net.velion.arena.stage;

import net.velion.arena.IArenaEntity;
import net.velion.arena.validation.ArenaInvalidException;

import java.util.ArrayList;
import java.util.Arrays;

public class StageList {
    private final ArrayList<Stage> stages;
    private int currentStage;

    public StageList() {
        stages = new ArrayList<>();
        currentStage = -1;
    }

    public StageList(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        currentStage = -1;
    }

    public void addStage(Stage stage) {
        stages.add(stage);
    }

    public Stage get(int index) {
        return stages.get(index);
    }

    public void next() {
        currentStage++;
        stages.get(currentStage).start();
    }

    public boolean hasNext() {
        return currentStage + 1 < stages.size();
    }

    public int size() {
        return stages.size();
    }

    public void setCurrentStage(int currentStage) {
        this.currentStage = currentStage;
    }

    public void previous() {
        currentStage--;
        stages.get(currentStage).start();
    }

    public boolean hasPrevious() {
        return currentStage - 1 >= 0;
    }

    public IArenaEntity check() {
        return stages.get(currentStage).check();
    }

    public void validate() throws ArenaInvalidException {
        if (stages == null || stages.isEmpty()) {
            throw new ArenaInvalidException(10);
        } else {
            for (Stage stage : stages) {
                stage.validate();
            }
        }
    }
}
