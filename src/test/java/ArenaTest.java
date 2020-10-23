import net.velion.arena.Arena;
import net.velion.arena.Player;
import net.velion.arena.capturing.CapturePoint;
import net.velion.arena.condition.TimeCondition;
import net.velion.arena.objective.CaptureObjective;
import net.velion.arena.objective.KillObjective;
import net.velion.arena.objective.ScoreObjective;
import net.velion.arena.order.GlobalOrder;
import net.velion.arena.order.Order;
import net.velion.arena.round.Round;
import net.velion.arena.stage.Stage;
import net.velion.arena.stage.Staging;
import net.velion.arena.validation.ArenaInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArenaTest {
    // TODO JUST IGNORE ALL TESTS! TESTS ARE ONLY HERE FOR DEBUGGING!

    @Test
    public void shouldHaveEntities() {
        Arena arena = new Arena("Arena 1");
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");

        arena.join(player1);
        arena.join(player2);
        arena.join(player3);

        assertEquals(3, arena.getPlayers().size());
        assertEquals(3, arena.getEntities().size());
    }

    @Test
    public void shouldHaveObjectivesAndGlobalObjectives() throws ArenaInvalidException {
        Arena arena = new Arena("Arena 2");
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        CapturePoint capturePoint1 = new CapturePoint("Capture Point 1");
        Round round = new Round(arena);
        TimeCondition timeCondition = new TimeCondition(arena, 100);
        Staging staging = new Staging();
        Stage stage = new Stage("DefaultStage", arena);
        GlobalOrder globalOrder = new GlobalOrder();
        Order order2 = new Order(player2);
        Order order3 = new Order(player3);
        ScoreObjective scoreObjective1 = new ScoreObjective(null, 100);
        ScoreObjective scoreObjective2 = new ScoreObjective(null, 101);
        ScoreObjective scoreObjective3 = new ScoreObjective(null, 102);
        KillObjective killObjective2 = new KillObjective(null, 10);
        KillObjective killObjective3 = new KillObjective(null, 11);
        CaptureObjective captureObjective = new CaptureObjective(capturePoint1, null);

        arena.addRound(round);
        round.addCondition(timeCondition);
        round.setStaging(staging);
        staging.setDefaultStage(stage);
        stage.setGlobalOrder(globalOrder);
        stage.addOrder(order2);
        stage.addOrder(order3);
        globalOrder.addObjective(scoreObjective1);
        globalOrder.addObjective(scoreObjective2);
        globalOrder.addObjective(scoreObjective3);
        order2.addObjective(killObjective2);
        order3.addObjective(killObjective3);
        order3.addObjective(captureObjective);
        arena.join(player1);
        arena.join(player2);
        arena.join(player3);
        arena.start();

        assertEquals(3, player1.getObjectives().size());
        assertEquals(4, player2.getObjectives().size());
        assertEquals(5, player3.getObjectives().size());
    }
}
