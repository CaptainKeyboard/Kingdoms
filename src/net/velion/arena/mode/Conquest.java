package net.velion.arena.mode;

import net.velion.arena.match.Match;
import net.velion.arena.team.Team;
import net.velion.controlling.CapturePoint;
import net.velion.controlling.SpawnPoint;

import java.util.List;

public class Conquest extends ArenaMode {
    final List<CapturePoint> capturePoint;

    public Conquest(Match match, List<Team> teams, List<SpawnPoint> spawnPoints, List<CapturePoint> capturePoint) {
        super(match, spawnPoints, teams);
        this.capturePoint = capturePoint;
    }
}
