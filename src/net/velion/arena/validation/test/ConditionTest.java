package net.velion.arena.validation.test;

import net.velion.arena.Arena;
import net.velion.arena.condition.TimeCondition;
import net.velion.arena.objective.KillObjective;
import net.velion.arena.order.GlobalOrder;
import net.velion.arena.round.Round;
import net.velion.arena.stage.Stage;
import net.velion.arena.stage.Staging;
import net.velion.arena.validation.ArenaInvalidException;
import org.junit.jupiter.api.Test;

public class ConditionTest {
    @Test
    public void timeCondition() throws ArenaInvalidException {
        Arena arena = new Arena("Arena 1");
        Round round = new Round(arena);
        Staging staging = new Staging();
        Stage stage = new Stage("Stage 1", arena);
        GlobalOrder globalOrder = new GlobalOrder();
        KillObjective killObjective = new KillObjective(null, 10);
        TimeCondition timeCondition = new TimeCondition(arena, 100);

        arena.addRound(round);
        round.addCondition(timeCondition);
        round.setStaging(staging);
        staging.setDefaultStage(stage);
        stage.setGlobalOrder(globalOrder);
        globalOrder.addObjective(killObjective);

        arena.start();
    }
}
