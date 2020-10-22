package net.velion.arena.condition;

import net.velion.arena.Arena;
import net.velion.arena.IArenaEntity;

public abstract class Condition {
    protected final Arena arena;
    protected final boolean evaluation;
    protected IArenaEntity winner;

    public Condition(Arena arena) {
        this.arena = arena;
        this.evaluation = false;
    }

    public Condition(Arena arena, boolean evaluation) {
        this.arena = arena;
        this.evaluation = evaluation;
    }

    public abstract boolean check();

    public IArenaEntity getWinner() {
        return winner;
    }

    public boolean isEvaluation() {
        return evaluation;
    }
}
