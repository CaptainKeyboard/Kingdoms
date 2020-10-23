package net.velion.arena.builder.builders;

import net.velion.arena.TeamArena;
import net.velion.arena.builder.builders.roundBuilder.RoundBuilder;

import java.util.List;

public class TeamArenaBuilder extends ArenaBuilder {
    private List<TeamBuilder> teamBuilders;

    public TeamArenaBuilder(String name) {
        super(name);
    }

    public TeamArenaBuilder setTeams(List<TeamBuilder> teamBuilders) {
        this.teamBuilders = teamBuilders;
        return this;
    }

    @Override
    public TeamArena build() {
        TeamArena teamArena = new TeamArena(name);
        for (CapturePointBuilder capturePointBuilder : capturePointBuilders) {
            teamArena.addCapturePoints(capturePointBuilder.build());
        }
        for (TeamBuilder teamBuilder : teamBuilders) {
            teamArena.addTeam(teamBuilder.build());
        }
        for (RoundBuilder roundBuilder : roundBuilders) {
            teamArena.addRound(roundBuilder.build(teamArena));
        }
        return teamArena;
    }

    @Override
    public TeamArenaBuilder setCapturePoint(List<CapturePointBuilder> capturePointBuilders) {
        return (TeamArenaBuilder) super.setCapturePoint(capturePointBuilders);
    }

    @Override
    public TeamArenaBuilder setRounds(List<RoundBuilder> roundBuilders) {
        return (TeamArenaBuilder) super.setRounds(roundBuilders);
    }
}
