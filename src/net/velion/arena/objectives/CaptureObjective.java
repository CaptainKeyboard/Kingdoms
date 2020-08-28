package net.velion.arena.objectives;

import net.velion.arena.match.Stage;
import net.velion.arena.team.Team;
import net.velion.controlling.CapturePoint;

public class CaptureObjective extends Objective<Team> {
    final CapturePoint capturePoint;

    public CaptureObjective(Stage stage, Team team, CapturePoint capturePoint) {
        super(stage, team);
        this.capturePoint = capturePoint;
        capturePoint.registerCaptureObjective(this);
    }

    @Override
    public boolean isReached() {
        if (capturePoint.getTeam() != null) {
            return capturePoint.getTeam().equals(team);
        }
        return false;
    }

    @Override
    public void update() {
        stage.check(team);
    }

    @Override
    public CaptureObjective copy(Team team) {
        return new CaptureObjective(this.stage, team, this.capturePoint);
    }
}
