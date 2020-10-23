package net.velion.arena.round;

import net.velion.arena.Arena;
import net.velion.arena.IArenaEntity;
import net.velion.arena.Status;
import net.velion.arena.condition.Condition;
import net.velion.arena.stage.Staging;
import net.velion.arena.validation.ArenaInvalidException;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private final Arena arena;
    private final List<Condition> conditions;
    private Staging staging;
    private Status status;

    public Round(Arena arena) {
        this.arena = arena;
        conditions = new ArrayList<>();
        status = Status.NOT_STARTED;
    }

    public void addCondition(Condition condition) {
        conditions.add(condition);
    }

    public void start() {
        staging.start();
        status = Status.RUNNING;
    }

    public Status check() {
        for (Condition condition : conditions) {
            if (condition.check()) {
                status = Status.OVER;
            }
        }
        return status;
    }

    public void update(IArenaEntity entity) {
        if (entity != null) {
            staging.update(entity);
        }
        arena.check();
    }

    public IArenaEntity getWinner() {
        IArenaEntity winner = null;
        for (Condition condition : conditions) {
            if (condition.check() || condition.isEvaluation()) {
                winner = condition.getWinner();
                if (winner != null) {
                    break;
                }
            }
        }
        return winner;
    }

    public Staging getStaging() {
        return staging;
    }

    public void setStaging(Staging staging) {
        this.staging = staging;
    }

    public void validate() throws ArenaInvalidException {
        if (staging == null) {
            throw new ArenaInvalidException(2);
        } else {
            staging.validate();
        }
        if (conditions.isEmpty()) {
            throw new ArenaInvalidException(11);
        }
    }

    public void reset() {
    }

    public Status getStatus() {
        return status;
    }
}
