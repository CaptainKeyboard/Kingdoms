package net.velion.arena.objectives;

import net.velion.arena.match.Stage;
import net.velion.arena.team.Team;

public abstract class Objective<T> {
    final Stage stage;
    final Team team;

    public Objective(Stage stage, Team team) {
        this.stage = stage;
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public abstract boolean isReached();

    public abstract void update();

    public abstract Objective copy(T value);
}