package net.velion.arena.test;

import net.velion.arena.Player;
import net.velion.arena.Team;
import net.velion.arena.TeamArena;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeamArenaTest {
    @Test
    public void shouldHaveEntities() {
        TeamArena teamArena = new TeamArena();
        Team redTeam = new Team();
        Team blueTeam = new Team();
        Team greenTeam = new Team();

        teamArena.addTeam(redTeam);
        teamArena.addTeam(blueTeam);
        teamArena.addTeam(greenTeam);

        assertEquals(3, teamArena.getEntities().size());
    }

    @Test
    public void shouldHaveEqualTeams() {
        TeamArena teamArena = new TeamArena();
        Team redTeam = new Team();
        Team blueTeam = new Team();
        Team greenTeam = new Team();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        Player player5 = new Player();
        Player player6 = new Player();

        teamArena.addTeam(redTeam);
        teamArena.addTeam(blueTeam);
        teamArena.addTeam(greenTeam);
        teamArena.join(player1);
        teamArena.join(player2);
        teamArena.join(player3);
        teamArena.join(player4);
        teamArena.join(player5);
        teamArena.join(player6);
        teamArena.start();



        assertEquals(2, redTeam.size());
        assertEquals(2, blueTeam.size());
        assertEquals(2, greenTeam.size());
    }
}
