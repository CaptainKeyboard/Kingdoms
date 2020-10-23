import net.velion.arena.Arena;
import net.velion.arena.Player;
import net.velion.arena.condition.LastStageCondition;
import net.velion.arena.objective.KillObjective;
import net.velion.arena.order.GlobalOrder;
import net.velion.arena.round.Round;
import net.velion.arena.stage.Stage;
import net.velion.arena.stage.Staging;
import org.junit.jupiter.api.Test;

public class DeathMatchTest {
    @Test
    public void singlePlayerDeathMatch() throws Exception {
        Arena arena = new Arena("DeathMatch 1");
        Round round = new Round(arena);
        LastStageCondition lastStageCondition = new LastStageCondition(arena);
        Staging staging = new Staging();
        Stage stage = new Stage("DefaultStage", arena);
        GlobalOrder globalOrder = new GlobalOrder();
        KillObjective killObjective = new KillObjective(null, 5);
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");
        Player player5 = new Player("Player 5");

        arena.addRound(round);
        round.addCondition(lastStageCondition);
        round.setStaging(staging);
        staging.setDefaultStage(stage);
        stage.setGlobalOrder(globalOrder);
        globalOrder.addObjective(killObjective);
        arena.join(player1);
        arena.join(player2);
        arena.join(player3);
        arena.join(player4);
        arena.join(player5);

        arena.start();

        arena.kill(player1);
        arena.kill(player1);
        arena.kill(player1);
        arena.kill(player1);
        arena.kill(player1);
    }
}
