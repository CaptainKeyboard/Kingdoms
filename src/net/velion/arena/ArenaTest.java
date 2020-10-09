package net.velion.arena;

import net.velion.arena.objective.CaptureObjective;
import net.velion.arena.objective.Objective;
import net.velion.arena.objective.ScoreObjective;
import net.velion.arena.order.Order;
import net.velion.arena.round.DynamicStagingRound;
import net.velion.arena.round.ForwardStagingRound;
import net.velion.arena.round.SingleStageRound;
import net.velion.arena.stage.MonoStage;
import net.velion.arena.stage.Stage;
import org.junit.jupiter.api.Test;

public class ArenaTest {
    @Test
    public void OneWayStorm() {
        TeamArena storm = new TeamArena();
        Team redTeam = new Team();
        Team blueTeam = new Team();
        SingleStageRound round = new SingleStageRound();
        MonoStage monoStage = new MonoStage(storm);
        ScoreObjective scoreObjective = new ScoreObjective(null, 100);

        storm.addTeam(redTeam);
        storm.addTeam(blueTeam);
        storm.addRound(round);
        round.addStage(monoStage);
        monoStage.addObjective(scoreObjective);

        storm.start();
    }

    @Test
    public void ThreeWayStorm() {
        TeamArena storm = new TeamArena();
        Team redTeam = new Team();
        Team blueTeam = new Team();
        Team greenTeam = new Team();
        DynamicStagingRound round = new DynamicStagingRound();
        MonoStage defaultStage = new MonoStage(storm);
        CaptureObjective cO0 = new CaptureObjective(null);
        MonoStage r1 = new MonoStage(storm);
        CaptureObjective cOR1 = new CaptureObjective(null);
        MonoStage b1 = new MonoStage(storm);
        CaptureObjective cOB1 = new CaptureObjective(null);
        MonoStage g1 = new MonoStage(storm);
        CaptureObjective cOG1 = new CaptureObjective(null);
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        Player player5 = new Player();
        Player player6 = new Player();


        storm.addTeam(redTeam);
        storm.addTeam(blueTeam);
        storm.addTeam(greenTeam);
        storm.addRound(round);
        round.setDefaultStage(defaultStage);
        defaultStage.addObjective(cO0);
        round.addStage(redTeam, r1);
        r1.addObjective(cOR1);
        round.addStage(blueTeam, b1);
        b1.addObjective(cOB1);
        round.addStage(greenTeam, g1);
        g1.addObjective(cOG1);
        storm.join(player1);
        storm.join(player2);
        storm.join(player3);
        storm.join(player4);
        storm.join(player5);
        storm.join(player6);
        storm.start();
    }
}
