package net.velion.arena.validation.test;

import net.velion.arena.Player;
import net.velion.arena.Team;
import net.velion.arena.TeamArena;
import net.velion.arena.capturing.CapturePoint;
import net.velion.arena.condition.TimeCondition;
import net.velion.arena.objective.CaptureObjective;
import net.velion.arena.order.GlobalOrder;
import net.velion.arena.round.Round;
import net.velion.arena.stage.Stage;
import net.velion.arena.stage.Staging;
import net.velion.arena.validation.ArenaInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConquestTest {
    @Test
    public void shouldRunArena() throws ArenaInvalidException {
        TeamArena teamArena = new TeamArena("Conquest 1");
        Team redTeam = new Team("Team 1");
        Team blueTeam = new Team("Team 2");
        CapturePoint capturePoint1 = new CapturePoint("Capture Point 1");
        CapturePoint capturePoint2 = new CapturePoint("Capture Point 2");
        CapturePoint capturePoint3 = new CapturePoint("Capture Point 3");
        CapturePoint capturePoint4 = new CapturePoint("Capture Point 4");
        CapturePoint capturePoint5 = new CapturePoint("Capture Point 5");
        Round round = new Round(teamArena);
        TimeCondition timeCondition = new TimeCondition(teamArena, 100);
        Staging staging = new Staging();
        Stage stage = new Stage("DefaultStage", teamArena);
        GlobalOrder globalOrder = new GlobalOrder();
        CaptureObjective captureObjective1 = new CaptureObjective(capturePoint1, null);
        CaptureObjective captureObjective2 = new CaptureObjective(capturePoint2, null);
        CaptureObjective captureObjective3 = new CaptureObjective(capturePoint3, null);
        CaptureObjective captureObjective4 = new CaptureObjective(capturePoint4, null);
        CaptureObjective captureObjective5 = new CaptureObjective(capturePoint5, null);


        teamArena.addTeam(redTeam);
        teamArena.addTeam(blueTeam);
        teamArena.addRound(round);
        round.addCondition(timeCondition);
        round.setStaging(staging);
        staging.setDefaultStage(stage);
        stage.setGlobalOrder(globalOrder);
        globalOrder.addObjective(captureObjective1);
        globalOrder.addObjective(captureObjective2);
        globalOrder.addObjective(captureObjective3);
        globalOrder.addObjective(captureObjective4);
        globalOrder.addObjective(captureObjective5);
        teamArena.start();
    }

    @Test
    public void shouldHaveObjectives() throws ArenaInvalidException {
        TeamArena teamArena = new TeamArena("Conquest 2");
        Team redTeam = new Team("Team 1");
        Team blueTeam = new Team("Team 2");
        CapturePoint capturePoint1 = new CapturePoint("Capture Point 1");
        CapturePoint capturePoint2 = new CapturePoint("Capture Point 2");
        CapturePoint capturePoint3 = new CapturePoint("Capture Point 3");
        CapturePoint capturePoint4 = new CapturePoint("Capture Point 4");
        CapturePoint capturePoint5 = new CapturePoint("Capture Point 5");
        Round round = new Round(teamArena);
        TimeCondition timeCondition = new TimeCondition(teamArena, 100);
        Staging staging = new Staging();
        Stage stage = new Stage("DefaultStage", teamArena);
        GlobalOrder globalOrder = new GlobalOrder();
        CaptureObjective captureObjective1 = new CaptureObjective(capturePoint1, null);
        CaptureObjective captureObjective2 = new CaptureObjective(capturePoint2, null);
        CaptureObjective captureObjective3 = new CaptureObjective(capturePoint3, null);
        CaptureObjective captureObjective4 = new CaptureObjective(capturePoint4, null);
        CaptureObjective captureObjective5 = new CaptureObjective(capturePoint5, null);
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");
        Player player5 = new Player("Player 5");
        Player player6 = new Player("Player 6");

        teamArena.addTeam(redTeam);
        teamArena.addTeam(blueTeam);
        teamArena.addRound(round);
        round.addCondition(timeCondition);
        round.setStaging(staging);
        staging.setDefaultStage(stage);
        stage.setGlobalOrder(globalOrder);
        globalOrder.addObjective(captureObjective1);
        globalOrder.addObjective(captureObjective2);
        globalOrder.addObjective(captureObjective3);
        globalOrder.addObjective(captureObjective4);
        globalOrder.addObjective(captureObjective5);
        teamArena.join(player1);
        teamArena.join(player2);
        teamArena.join(player3);
        teamArena.join(player4);
        teamArena.join(player5);
        teamArena.join(player6);
        teamArena.start();

        assertEquals(5, player1.getObjectives().size());
        assertEquals(5, player2.getObjectives().size());
        assertEquals(5, player3.getObjectives().size());
        assertEquals(5, player4.getObjectives().size());
        assertEquals(5, player5.getObjectives().size());
        assertEquals(5, player6.getObjectives().size());
    }
}
