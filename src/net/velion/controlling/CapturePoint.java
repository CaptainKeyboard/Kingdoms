package net.velion.controlling;

import net.velion.Player;
import net.velion.arena.Arena;
import net.velion.arena.match.Stage;
import net.velion.arena.objectives.CaptureObjective;
import net.velion.arena.team.Team;

import java.util.ArrayList;
import java.util.List;

public class CapturePoint extends ControlPoint {
    Team team;
    final List<CaptureObjective> captureObjectives;
    Stage stage;

    public CapturePoint(Arena arena, Location location, String name) {
        super(arena, location, name);
        captureObjectives = new ArrayList<CaptureObjective>();
    }

    public void claim(Player player) {
        team = player.getTeam();
        team.getTeamScoreboard().addCapture(player);
        for(CaptureObjective captureObjective: captureObjectives) {
            captureObjective.update();
        }
    }

    public void registerCaptureObjective(CaptureObjective captureObjective) {
        captureObjectives.add(captureObjective);
    }

    public void deregisterCaptureObjective(CaptureObjective captureObjective) {
        captureObjectives.remove(captureObjective);
    }

    public Team getTeam() {
        return team;
    }
}
