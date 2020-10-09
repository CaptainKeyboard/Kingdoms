package net.velion.arena.test;

import net.velion.arena.Player;
import net.velion.arena.Team;
import net.velion.arena.TeamArena;
import net.velion.arena.objective.CaptureObjective;
import net.velion.arena.round.SingleStageRound;
import net.velion.arena.stage.MonoStage;
import org.junit.jupiter.api.Test;

public class ConquestTest {
    @Test
    public void shouldRunArena() {
        TeamArena teamArena = new TeamArena();
        Team redTeam = new Team();
        Team blueTeam = new Team();
        SingleStageRound singleStageRound = new SingleStageRound();
        MonoStage monoStage = new MonoStage(teamArena);
        CaptureObjective captureObjective1 = new CaptureObjective(null);
        CaptureObjective captureObjective2 = new CaptureObjective(null);
        CaptureObjective captureObjective3 = new CaptureObjective(null);
        CaptureObjective captureObjective4 = new CaptureObjective(null);
        CaptureObjective captureObjective5 = new CaptureObjective(null);


        teamArena.addTeam(redTeam);
        teamArena.addTeam(blueTeam);
        teamArena.addRound(singleStageRound);
        singleStageRound.addStage(monoStage);
        monoStage.addObjective(captureObjective1);
        monoStage.addObjective(captureObjective2);
        monoStage.addObjective(captureObjective3);
        monoStage.addObjective(captureObjective4);
        monoStage.addObjective(captureObjective5);
        teamArena.start();
    }

    @Test
    public void shouldHaveObjectives() {
        TeamArena teamArena = new TeamArena();
        Team redTeam = new Team();
        Team blueTeam = new Team();
        SingleStageRound singleStageRound = new SingleStageRound();
        MonoStage monoStage = new MonoStage(teamArena);
        CaptureObjective captureObjective1 = new CaptureObjective(null);
        CaptureObjective captureObjective2 = new CaptureObjective(null);
        CaptureObjective captureObjective3 = new CaptureObjective(null);
        CaptureObjective captureObjective4 = new CaptureObjective(null);
        CaptureObjective captureObjective5 = new CaptureObjective(null);
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        Player player5 = new Player();
        Player player6 = new Player();


        teamArena.addTeam(redTeam);
        teamArena.addTeam(blueTeam);
        teamArena.addRound(singleStageRound);
        singleStageRound.addStage(monoStage);
        monoStage.addObjective(captureObjective1);
        monoStage.addObjective(captureObjective2);
        monoStage.addObjective(captureObjective3);
        monoStage.addObjective(captureObjective4);
        monoStage.addObjective(captureObjective5);
        teamArena.start();
    }
}
