package net.velion.arena.objectives;

import net.velion.arena.match.Stage;
import net.velion.arena.scoring.TeamScoreboard;
import net.velion.arena.team.Team;

public class TeamScoreObjective extends Objective<TeamScoreboard> {
    final int score;

    public TeamScoreObjective(Stage stage, Team team, int score) {
        super(stage, team);
        this.score = score;
    }

    @Override
    public boolean isReached() {
        return team.getTeamScoreboard().getTeamScore() == score;
    }

    @Override
    public void update() {

    }

    @Override
    public Objective copy(TeamScoreboard team) {
        return null;
    }
}
