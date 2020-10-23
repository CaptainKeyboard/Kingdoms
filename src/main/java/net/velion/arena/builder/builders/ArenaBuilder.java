package net.velion.arena.builder.builders;

import net.velion.arena.Arena;
import net.velion.arena.builder.builders.roundBuilder.RoundBuilder;

import java.util.List;

public abstract class ArenaBuilder {
    protected String name;
    protected List<RoundBuilder> roundBuilders;
    protected List<CapturePointBuilder> capturePointBuilders;

    public ArenaBuilder(String name) {
        this.name = name;
    }

    public ArenaBuilder setCapturePoint(List<CapturePointBuilder> capturePointBuilders) {
        this.capturePointBuilders = capturePointBuilders;
        return this;
    }

    public ArenaBuilder setRounds(List<RoundBuilder> roundBuilders) {
        this.roundBuilders = roundBuilders;
        return this;
    }

    public Arena build() {
        Arena arena = new Arena(name);
        for (CapturePointBuilder capturePointBuilder : capturePointBuilders) {
            arena.addCapturePoints(capturePointBuilder.build());
        }
        for (RoundBuilder roundBuilder : roundBuilders) {
            arena.addRound(roundBuilder.build(arena));
        }
        return arena;
    }
}
