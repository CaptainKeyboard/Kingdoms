package net.velion.arena.builder.builders;

import net.velion.arena.Team;

public class TeamBuilder {
    private String name;

    public TeamBuilder(String name) {
        this.name = name;
    }

    public Team build() {
        return new Team(name);
    }
}
