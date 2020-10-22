package net.velion.arena.condition;

import net.velion.arena.Arena;
import net.velion.arena.IArenaEntity;

public class TimeCondition extends Condition {
    private final int time;

    public TimeCondition(Arena arena, int time) {
        super(arena);
        this.time = time;
    }

    public TimeCondition(Arena arena, int time, IArenaEntity winner) {
        super(arena);
        this.time = time;
        this.winner = winner;
    }

    @Override
    public boolean check() {
        return arena.getCurrentTime() >= time;
    }
}
