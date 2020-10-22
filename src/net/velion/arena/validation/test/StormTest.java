package net.velion.arena.validation.test;

import net.velion.arena.Player;
import net.velion.arena.Team;
import net.velion.arena.TeamArena;
import net.velion.arena.capturing.CapturePoint;
import net.velion.arena.condition.LastStageCondition;
import net.velion.arena.condition.ScoreCondition;
import net.velion.arena.condition.TimeCondition;
import net.velion.arena.objective.CaptureObjective;
import net.velion.arena.objective.ScoreObjective;
import net.velion.arena.order.GlobalOrder;
import net.velion.arena.round.Round;
import net.velion.arena.stage.ComplexStaging;
import net.velion.arena.stage.Stage;
import org.junit.jupiter.api.Test;

public class StormTest {
    @Test
    public void twoWayStorm() throws Exception {
        TeamArena teamArena = new TeamArena("Storm 1");
        Team redTeam = new Team("Team 1");
        Team blueTeam = new Team("Team 2");
        Round round = new Round(teamArena);
        TimeCondition timeCondition = new TimeCondition(teamArena, 100);
        ComplexStaging complexStaging = new ComplexStaging();
        Stage stage1 = new Stage("DefaultStage", teamArena);
        Stage stage2 = new Stage("Stage R1", teamArena);
        Stage stage3 = new Stage("Stage R2", teamArena);
        Stage stage4 = new Stage("Stage B1", teamArena);
        Stage stage5 = new Stage("Stage B2", teamArena);
        GlobalOrder order1 = new GlobalOrder();
        GlobalOrder order2 = new GlobalOrder();
        GlobalOrder order3 = new GlobalOrder();
        GlobalOrder order4 = new GlobalOrder();
        GlobalOrder order5 = new GlobalOrder();
        ScoreObjective scoreObjective1 = new ScoreObjective(null, 100);
        ScoreObjective scoreObjective2 = new ScoreObjective(null, 100);
        ScoreObjective scoreObjective3 = new ScoreObjective(null, 100);
        ScoreObjective scoreObjective4 = new ScoreObjective(null, 100);
        ScoreObjective scoreObjective5 = new ScoreObjective(null, 100);
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");

        teamArena.addTeam(redTeam);
        teamArena.addTeam(blueTeam);
        teamArena.addRound(round);
        round.addCondition(timeCondition);
        round.setStaging(complexStaging);
        complexStaging.setDefaultStage(stage1);
        complexStaging.addStage(redTeam, stage2);
        complexStaging.addStage(redTeam, stage3);
        complexStaging.addStage(blueTeam, stage4);
        complexStaging.addStage(blueTeam, stage5);
        stage1.setGlobalOrder(order1);
        stage2.setGlobalOrder(order2);
        stage3.setGlobalOrder(order3);
        stage4.setGlobalOrder(order4);
        stage5.setGlobalOrder(order5);
        order1.addObjective(scoreObjective1);
        order2.addObjective(scoreObjective2);
        order3.addObjective(scoreObjective3);
        order4.addObjective(scoreObjective4);
        order5.addObjective(scoreObjective5);
        teamArena.join(player1);
        teamArena.join(player2);
        teamArena.join(player3);
        teamArena.join(player4);

        teamArena.start();
        teamArena.kill(player1);
    }

    @Test
    public void threeWayStorm() throws Exception {
        TeamArena teamArena = new TeamArena("Storm 2");
        Team redTeam = new Team("Team 1");
        Team blueTeam = new Team("Team 2");
        Team greenTeam = new Team("Team 3");
        CapturePoint capturePoint1 = new CapturePoint("Capture Point 1");
        CapturePoint capturePoint2 = new CapturePoint("Capture Point 2");
        CapturePoint capturePoint3 = new CapturePoint("Capture Point 3");
        CapturePoint capturePoint4 = new CapturePoint("Capture Point 4");
        Round round = new Round(teamArena);
        TimeCondition timeCondition = new TimeCondition(teamArena, 100);
        LastStageCondition lastStageCondition = new LastStageCondition(teamArena);
        ScoreCondition scoreCondition = new ScoreCondition(teamArena, 1000, true);
        ComplexStaging complexStaging = new ComplexStaging();
        Stage defaultStage = new Stage("DefaultStage", teamArena);
        Stage r1 = new Stage("Stage R1", teamArena);
        Stage b1 = new Stage("Stage B1", teamArena);
        Stage g1 = new Stage("Stage G1", teamArena);
        GlobalOrder o0 = new GlobalOrder();
        GlobalOrder oR1 = new GlobalOrder();
        GlobalOrder oB1 = new GlobalOrder();
        GlobalOrder oG1 = new GlobalOrder();
        CaptureObjective cO0 = new CaptureObjective(capturePoint1, null);
        CaptureObjective cOR1 = new CaptureObjective(capturePoint2, null);
        CaptureObjective cOB1 = new CaptureObjective(capturePoint3, null);
        CaptureObjective cOG1 = new CaptureObjective(capturePoint4, null);
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");
        Player player5 = new Player("Player 5");
        Player player6 = new Player("Player 6");

        teamArena.addTeam(redTeam);
        teamArena.addTeam(blueTeam);
        teamArena.addTeam(greenTeam);
        teamArena.addRound(round);
        round.addCondition(timeCondition);
        round.addCondition(lastStageCondition);
        round.addCondition(scoreCondition);
        round.setStaging(complexStaging);
        complexStaging.setDefaultStage(defaultStage);
        complexStaging.addStage(redTeam, r1);
        complexStaging.addStage(blueTeam, b1);
        complexStaging.addStage(greenTeam, g1);
        defaultStage.setGlobalOrder(o0);
        r1.setGlobalOrder(oR1);
        b1.setGlobalOrder(oB1);
        g1.setGlobalOrder(oG1);
        o0.addObjective(cO0);
        oR1.addObjective(cOR1);
        oB1.addObjective(cOB1);
        oG1.addObjective(cOG1);
        teamArena.join(player1);
        teamArena.join(player2);
        teamArena.join(player3);
        teamArena.join(player4);
        teamArena.join(player5);
        teamArena.join(player6);
        teamArena.start();

        teamArena.capture(capturePoint1, redTeam.getMembers().get(0));
        teamArena.capture(capturePoint2, blueTeam.getMembers().get(0));
        teamArena.capture(capturePoint1, blueTeam.getMembers().get(0));
        teamArena.capture(capturePoint3, redTeam.getMembers().get(0));
        teamArena.capture(capturePoint1, greenTeam.getMembers().get(0));
        teamArena.setTime(1000);
        teamArena.capture(capturePoint4, greenTeam.getMembers().get(0));
    }
}
