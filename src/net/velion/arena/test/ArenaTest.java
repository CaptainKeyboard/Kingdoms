package net.velion.arena.test;

import net.velion.arena.Arena;
import net.velion.arena.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    @Test
    public void shouldHaveEntities() {
        Arena arena = new Arena();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        arena.join(player1);
        arena.join(player2);
        arena.join(player3);

        assertEquals(3, arena.getPlayers());
        assertEquals(3, arena.getEntities());
    }
}
